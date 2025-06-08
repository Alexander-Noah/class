import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 请假申请页面
 * 请假申请页面
 * 请假申请页面
 */
public class LeaveApplication extends JFrame {
    // 组件声明
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel typeLabel;
    private JComboBox<String> typeComboBox;
    private JLabel startDateLabel;
    private JTextField startDateField;
    private JButton startDateButton;
    private JLabel endDateLabel;
    private JTextField endDateField;
    private JButton endDateButton;
    private JLabel reasonLabel;
    private JTextArea reasonArea;
    private JScrollPane scrollPane;
    private JButton submitButton;
    private JButton cancelButton;

    public LeaveApplication() {
        initFrame();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initComponents() {
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        // === 标题 ===
        titleLabel = new JLabel("请假申请");
        titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
        titleLabel.setBounds(180, 10, 120, 30);
        contentPane.add(titleLabel);

        // === 姓名 ===
        nameLabel = new JLabel("姓    名:");
        nameLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        nameLabel.setBounds(50, 60, 80, 25);
        contentPane.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(140, 60, 200, 25);
        nameField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        contentPane.add(nameField);

        // === 学号/工号 ===
        idLabel = new JLabel("学号/工号:");
        idLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        idLabel.setBounds(50, 100, 80, 25);
        contentPane.add(idLabel);

        idField = new JTextField();
        idField.setBounds(140, 100, 200, 25);
        idField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        contentPane.add(idField);

        // === 请假类型 ===
        typeLabel = new JLabel("请假类型:");
        typeLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        typeLabel.setBounds(50, 140, 80, 25);
        contentPane.add(typeLabel);

        String[] leaveTypes = {"病假", "事假", "婚假", "产假", "丧假", "其他"};
        typeComboBox = new JComboBox<>(leaveTypes);
        typeComboBox.setBounds(140, 140, 200, 25);
        typeComboBox.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        contentPane.add(typeComboBox);

        // === 开始日期 ===
        startDateLabel = new JLabel("开始日期:");
        startDateLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        startDateLabel.setBounds(50, 180, 80, 25);
        contentPane.add(startDateLabel);

        startDateField = new JTextField();
        startDateField.setBounds(140, 180, 150, 25);
        startDateField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        startDateField.setEditable(false);
        contentPane.add(startDateField);

        startDateButton = new JButton("选择");
        startDateButton.setBounds(300, 180, 80, 25);
        startDateButton.addActionListener(e -> {
            String date = showDatePicker();
            if (date != null) {
                startDateField.setText(date);
            }
        });
        contentPane.add(startDateButton);

        // === 结束日期 ===
        endDateLabel = new JLabel("结束日期:");
        endDateLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        endDateLabel.setBounds(50, 220, 80, 25);
        contentPane.add(endDateLabel);

        endDateField = new JTextField();
        endDateField.setBounds(140, 220, 150, 25);
        endDateField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));
        endDateField.setEditable(false);
        contentPane.add(endDateField);

        endDateButton = new JButton("选择");
        endDateButton.setBounds(300, 220, 80, 25);
        endDateButton.addActionListener(e -> {
            String date = showDatePicker();
            if (date != null) {
                endDateField.setText(date);
            }
        });
        contentPane.add(endDateButton);

        // === 请假原因 ===
        reasonLabel = new JLabel("请假原因:");
        reasonLabel.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        reasonLabel.setBounds(50, 260, 80, 25);
        contentPane.add(reasonLabel);

        reasonArea = new JTextArea();
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);
        reasonArea.setFont(new Font("Microsoft YaHei", Font.PLAIN, 14));

        scrollPane = new JScrollPane(reasonArea);
        scrollPane.setBounds(140, 260, 300, 100);
        contentPane.add(scrollPane);

        // === 按钮 ===
        submitButton = new JButton("提交申请");
        submitButton.setBounds(120, 380, 120, 30);
        submitButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        submitButton.addActionListener(e -> submitApplication());
        contentPane.add(submitButton);

        cancelButton = new JButton("取消");
        cancelButton.setBounds(280, 380, 120, 30);
        cancelButton.setFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        cancelButton.addActionListener(e -> this.dispose());
        contentPane.add(cancelButton);
    }

    private void initFrame() {
        this.setTitle("请假申请系统");
        this.setSize(500, 480);
        this.setResizable(false);
    }

    /**
     * 显示日期选择对话框
     */
    private String showDatePicker() {
        // 这里简化实现，实际应用中可以使用JCalendar等日期选择组件
        String input = JOptionPane.showInputDialog(this, "请输入日期(YYYY-MM-DD):",
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        if (input != null && !input.trim().isEmpty()) {
            return input;
        }
        return null;
    }

    /**
     * 提交申请
     */
    private void submitApplication() {
        // 验证输入
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入姓名", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (startDateField.getText().isEmpty() || endDateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请选择请假日期", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (reasonArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "请输入请假原因", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 构造申请信息
        String message = "请假申请信息:\n\n" +
                "姓名: " + nameField.getText() + "\n" +
                "学号/工号: " + idField.getText() + "\n" +
                "请假类型: " + typeComboBox.getSelectedItem() + "\n" +
                "请假时间: " + startDateField.getText() + " 至 " + endDateField.getText() + "\n" +
                "请假原因: " + reasonArea.getText();

        // 显示确认对话框
        int option = JOptionPane.showConfirmDialog(this, message, "确认提交",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, "请假申请已提交", "成功", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LeaveApplication());
    }
}