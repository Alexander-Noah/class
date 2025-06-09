import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 教师审批请假，已经接入主UI
 */
public class StudentLeaveApprovalSystem extends JFrame {

    // 组件声明
    private JLabel titleLabel;
    private JTable leaveTable;
    private JScrollPane tableScrollPane;
    private JLabel detailLabel;
    private JTextArea detailArea;
    private JScrollPane detailScrollPane;
    private JLabel statusLabel;
    private JComboBox<String> statusComboBox;
    private JButton approveButton;
    private JButton rejectButton;
    private JButton refreshButton;
    private JButton exportButton;
    private JTextField searchField;
    private JButton searchButton;
    private JButton backButton;

    // 数据模型
    private DefaultTableModel tableModel;
    private List<StudentLeaveApplication> leaveApplications;

    // 表格列名
    private final String[] COLUMN_NAMES = {"申请ID", "学生姓名", "学号", "请假类型", "开始时间", "结束时间", "状态"};

    public StudentLeaveApprovalSystem() {
        initData();     // 初始化数据
        initFrame();    // 初始化窗口
        initComponents(); // 初始化组件
        this.setLocationRelativeTo(null); // 窗口居中
        this.setVisible(true); // 显示窗口
    }

    /**
     * 初始化模拟数据
     */
    private void initData() {
        leaveApplications = new ArrayList<>();

        // 添加模拟数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentTime = sdf.format(new Date());

        leaveApplications.add(new StudentLeaveApplication(1, "张三", "2023001", "病假",
                "2023-10-15 08:00", "2023-10-17 17:00", "待审批", "感冒发烧，医生建议休息3天"));
        leaveApplications.add(new StudentLeaveApplication(2, "李四", "2023002", "事假",
                "2023-10-18 08:00", "2023-10-18 17:00", "待审批", "家中急事需要处理"));
        leaveApplications.add(new StudentLeaveApplication(3, "王五", "2023003", "其他",
                "2023-10-20 08:00", "2023-10-21 17:00", "已批准", "参加比赛"));
    }

    /**
     * 初始化窗口框架
     */
    private void initFrame() {
        this.setTitle("学生请假审批系统 - 教师端");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new Color(240, 240, 240));
    }

    /**
     * 初始化所有组件
     */
    private void initComponents() {
        // === 1. 顶部面板 ===
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 1.1 标题
        titleLabel = new JLabel("学生请假审批系统", JLabel.CENTER);
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // 1.2 搜索面板
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        searchPanel.setBorder(BorderFactory.createTitledBorder("搜索学生请假申请"));

        searchField = new JTextField(20);
        searchField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        searchPanel.add(new JLabel("学生姓名/学号:"));
        searchPanel.add(searchField);

        searchButton = new JButton("搜索");
        styleButton(searchButton, new Color(33, 150, 243));
        searchButton.addActionListener(e -> searchApplications());
        searchPanel.add(searchButton);

        topPanel.add(searchPanel, BorderLayout.SOUTH);
        this.add(topPanel, BorderLayout.NORTH);

        // === 2. 中部：申请表格和详情 ===
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 15, 15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        // 2.1 请假申请表格
        tableModel = new DefaultTableModel(COLUMN_NAMES, 0);
        updateTableData();

        leaveTable = new JTable(tableModel);
        leaveTable.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        leaveTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        leaveTable.setRowHeight(30);
        leaveTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = leaveTable.getSelectedRow();
            if (selectedRow >= 0) {
                updateDetailArea(selectedRow);
            }
        });

        tableScrollPane = new JScrollPane(leaveTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("学生请假申请列表"));
        centerPanel.add(tableScrollPane);

        // 2.2 申请详情面板
        JPanel detailPanel = new JPanel(new BorderLayout());
        detailPanel.setBorder(BorderFactory.createTitledBorder("申请详情"));

        detailLabel = new JLabel();
        detailLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        detailPanel.add(detailLabel, BorderLayout.NORTH);

        detailArea = new JTextArea();
        detailArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        detailArea.setEditable(false);
        detailArea.setLineWrap(true);
        detailArea.setWrapStyleWord(true);
        detailArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        detailScrollPane = new JScrollPane(detailArea);
        detailPanel.add(detailScrollPane, BorderLayout.CENTER);

        centerPanel.add(detailPanel);
        this.add(centerPanel, BorderLayout.CENTER);

        // === 3. 底部：审批操作 ===
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        bottomPanel.setBorder(BorderFactory.createEtchedBorder());

        // 3.1 状态选择
        statusLabel = new JLabel("审批操作:");
        statusLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        bottomPanel.add(statusLabel);

        String[] statusOptions = {"批准", "拒绝", "待补充材料"};
        statusComboBox = new JComboBox<>(statusOptions);
        statusComboBox.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        statusComboBox.setPreferredSize(new Dimension(120, 30));
        bottomPanel.add(statusComboBox);

        // 3.2 审批按钮
        approveButton = new JButton("提交审批");
        styleButton(approveButton, new Color(76, 175, 80));
        approveButton.addActionListener(e -> processApproval());
        bottomPanel.add(approveButton);

        // 3.3 刷新按钮
        refreshButton = new JButton("刷新列表");
        styleButton(refreshButton, new Color(33, 150, 243));
        refreshButton.addActionListener(e -> refreshApplications());
        bottomPanel.add(refreshButton);

        // 3.4 导出按钮
        exportButton = new JButton("导出数据");
        styleButton(exportButton, new Color(255, 152, 0));
        exportButton.addActionListener(e -> exportData());
        bottomPanel.add(exportButton);

        //返回按钮
        backButton = new JButton("返回");
        styleButton(backButton, new Color(120, 120, 120)); // Adjusted color for distinction
        backButton.addActionListener(e -> BackButtonActionPerformed());
        bottomPanel.add(backButton);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * 更新表格数据
     */
    private void updateTableData() {
        tableModel.setRowCount(0); // 清空表格

        for (StudentLeaveApplication app : leaveApplications) {
            Object[] rowData = {
                    app.getId(),
                    app.getStudentName(),
                    app.getStudentId(),
                    app.getLeaveType(),
                    app.getStartTime(),
                    app.getEndTime(),
                    app.getStatus()
            };
            tableModel.addRow(rowData);
        }
    }

    /**
     * 更新详情区域
     *
     * @param rowIndex 表格中选中的行索引
     */
    private void updateDetailArea(int rowIndex) {
        // Find the correct application based on the ID in the table view,
        // which is safer after a search/filter operation.
        int modelRowIndex = leaveTable.convertRowIndexToModel(rowIndex);
        int applicationId = (int) tableModel.getValueAt(modelRowIndex, 0);

        StudentLeaveApplication app = leaveApplications.stream()
                .filter(a -> a.getId() == applicationId)
                .findFirst()
                .orElse(null);

        if (app == null) return;

        String detailInfo = String.format(
                "学生姓名: %s\n" +
                        "学    号: %s\n" +
                        "请假类型: %s\n" +
                        "请假时间: %s 至 %s\n" +
                        "当前状态: %s\n\n" +
                        "请假原因:\n%s",
                app.getStudentName(),
                app.getStudentId(),
                app.getLeaveType(),
                app.getStartTime(),
                app.getEndTime(),
                app.getStatus(),
                app.getReason()
        );

        detailLabel.setText("申请ID: " + app.getId());
        detailArea.setText(detailInfo);
    }

    /**
     * 处理审批操作
     */
    private void processApproval() {
        int selectedRow = leaveTable.getSelectedRow();
        if (selectedRow < 0) {
            showMessage("请先选择一条请假申请记录", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String decision = (String) statusComboBox.getSelectedItem();

        // Get application ID from the selected row in the table model
        int modelRowIndex = leaveTable.convertRowIndexToModel(selectedRow);
        int applicationId = (int) tableModel.getValueAt(modelRowIndex, 0);

        // Find the application in the master list
        StudentLeaveApplication app = leaveApplications.stream()
                .filter(a -> a.getId() == applicationId)
                .findFirst()
                .orElse(null);

        if (app == null) {
            showMessage("无法找到所选的申请记录。", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 更新状态
        String newStatus;
        switch (decision) {
            case "批准":
                newStatus = "已批准";
                break;
            case "拒绝":
                newStatus = "已拒绝";
                break;
            case "待补充材料":
                newStatus = "待补充材料";
                break;
            default:
                newStatus = app.getStatus(); // No change
                break;
        }

        app.setStatus(newStatus);

        // 更新表格
        tableModel.setValueAt(newStatus, modelRowIndex, 6);

        // 记录审批人和审批时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String approvalInfo = "\n\n审批信息:\n" +
                "审批教师: 李老师\n" + // This could be replaced with actual logged-in user info
                "审批时间: " + sdf.format(new Date()) +
                "\n审批结果: " + newStatus;

        if ("待补充材料".equals(newStatus)) {
            approvalInfo += "\n需补充材料: 请上传医院证明或其他相关材料";
        }

        detailArea.append(approvalInfo);

        showMessage("审批操作已提交", "成功", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 搜索申请
     */
    private void searchApplications() {
        String keyword = searchField.getText().trim().toLowerCase();

        if (keyword.isEmpty()) {
            updateTableData();
            return;
        }

        tableModel.setRowCount(0); // 清空表格

        for (StudentLeaveApplication app : leaveApplications) {
            if (app.getStudentName().toLowerCase().contains(keyword) ||
                    app.getStudentId().toLowerCase().contains(keyword)) {
                Object[] rowData = {
                        app.getId(),
                        app.getStudentName(),
                        app.getStudentId(),
                        app.getLeaveType(),
                        app.getStartTime(),
                        app.getEndTime(),
                        app.getStatus()
                };
                tableModel.addRow(rowData);
            }
        }
    }

    /**
     * 刷新申请列表
     */
    private void refreshApplications() {
        searchField.setText("");
        updateTableData();
        showMessage("请假申请列表已刷新", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 导出数据
     */
    private void exportData() {
        if (leaveApplications.isEmpty()) {
            showMessage("没有数据可供导出。", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("导出请假审批数据为 CSV 文件");
        // Suggest a default filename
        fileChooser.setSelectedFile(new File("leave_applications_export.csv"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Ensure the file has a .csv extension
            if (!fileToSave.getName().toLowerCase().endsWith(".csv")) {
                fileToSave = new File(fileToSave.getParentFile(), fileToSave.getName() + ".csv");
            }

            // Use try-with-resources to handle the FileWriter and BufferedWriter automatically
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                // Define headers for the CSV file, including the reason
                String[] csvHeaders = {COLUMN_NAMES[0], COLUMN_NAMES[1], COLUMN_NAMES[2], COLUMN_NAMES[3],
                        COLUMN_NAMES[4], COLUMN_NAMES[5], COLUMN_NAMES[6], "请假原因"};
                writer.write(String.join(",", csvHeaders));
                writer.newLine();

                // Write the data rows
                for (StudentLeaveApplication app : leaveApplications) {
                    // Sanitize the reason field to handle commas and newlines for proper CSV formatting
                    String sanitizedReason = "\"" + app.getReason().replace("\"", "\"\"").replace("\n", " ") + "\"";

                    String[] rowData = {
                            String.valueOf(app.getId()),
                            app.getStudentName(),
                            app.getStudentId(),
                            app.getLeaveType(),
                            app.getStartTime(),
                            app.getEndTime(),
                            app.getStatus(),
                            sanitizedReason
                    };
                    writer.write(String.join(",", rowData));
                    writer.newLine();
                }

                showMessage("数据已成功导出到: " + fileToSave.getAbsolutePath(),
                        "导出成功", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                // Log the exception and show an error message to the user
                ex.printStackTrace();
                showMessage("导出数据时发生错误: " + ex.getMessage(),
                        "导出失败", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void BackButtonActionPerformed() {
        // Assuming 'UI' is another frame in your application
        // For demonstration, this will just close the current window.
         new UI(1); // Your original code
        this.dispose(); // Close this window
    }

    /**
     * 样式化按钮
     */
    private void styleButton(JButton button, Color bgColor) {
        button.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }

    /**
     * 显示消息对话框
     */
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    /**
     * 学生请假申请数据模型类
     */
    private static class StudentLeaveApplication {
        private int id;
        private String studentName;
        private String studentId;
        private String leaveType;
        private String startTime;
        private String endTime;
        private String status;
        private String reason;

        public StudentLeaveApplication(int id, String studentName, String studentId, String leaveType,
                                       String startTime, String endTime,
                                       String status, String reason) {
            this.id = id;
            this.studentName = studentName;
            this.studentId = studentId;
            this.leaveType = leaveType;
            this.startTime = startTime;
            this.endTime = endTime;
            this.status = status;
            this.reason = reason;
        }

        // Getter方法
        public int getId() { return id; }
        public String getStudentName() { return studentName; }
        public String getStudentId() { return studentId; }
        public String getLeaveType() { return leaveType; }
        public String getStartTime() { return startTime; }
        public String getEndTime() { return endTime; }
        public String getStatus() { return status; }
        public String getReason() { return reason; }

        // Setter方法
        public void setStatus(String status) { this.status = status; }
    }

    public static void main(String[] args) {
        // Use the event dispatch thread to build and show the UI
        SwingUtilities.invokeLater(() -> new StudentLeaveApprovalSystem());
    }
}