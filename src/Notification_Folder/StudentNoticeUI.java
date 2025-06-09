//import javax.swing.*;
//import java.awt.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class studentNoticeUI extends JFrame {
//    private DefaultListModel<String> listModel;
//    private JList<String> noticeList;
//    private List<String> notices;
//
//    public studentNoticeUI() {
//        setTitle("学生通知接收系统");
//        setSize(500, 400);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        // 初始化虚拟通知数据
//        notices = new ArrayList<>();
//        notices.add(formatNotice("审批通知","通过"));
//
//        // UI组件
//        listModel = new DefaultListModel<>();
//        noticeList = new JList<>(listModel);
//        noticeList.setFont(new Font("Monospaced", Font.PLAIN, 14));
//        JScrollPane scrollPane = new JScrollPane(noticeList);
//
//        JButton refreshBtn = new JButton("刷新通知");
//        JButton addBtn = new JButton("返回");
//
//        refreshBtn.addActionListener(e -> loadNotices());
//        addBtn.addActionListener(e -> {
//
//                }
//            }
//        });
//
//    // 格式化通知
//    private String formatNotice(String title, String content) {
//        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        return "[" + time + "] " + title + ": " + content;
//    }
//
//    public void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new studentNoticeUI().setVisible(true);
//        });
//    }
//
