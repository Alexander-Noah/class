import javax.swing.*;
import java.awt.*;

/**
 * 通知模块界面类
 * @author zheng
 */
public class NotificationModule extends JFrame {
    // 界面组件声明
    private JLabel Title;          // 标题标签
    private JButton Backbutton;    // 返回按钮
    private JLabel ContactText;    // "发布人"标签
    private JLabel ContentText;    // "内容"标签
    private JTextField textField3; // 发布人输入框（只读）
    private JTextArea textArea;    // 内容文本区域（多行，只读）
    private JScrollPane scrollPane;// 滚动面板（用于包裹文本区域）

    /**
     * 构造函数：初始化通知界面
     */
    public NotificationModule() {
        initFrame();       // 初始化框架设置
        initComponents();  // 初始化界面组件
        this.setLocationRelativeTo(null);          // 窗口居中显示
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // 关闭窗口时退出程序
        this.setVisible(true);                    // 显示界面
    }

    /**
     * 初始化界面组件
     */
    private void initComponents() {
        // 获取内容面板并设置为绝对布局
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //=== 标题设置 ===
        Title.setText("通知");
        Title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        contentPane.add(Title);
        Title.setBounds(175, 10, 60, 30);  // 设置位置和大小

        //=== 返回按钮设置 ===
        Backbutton.setText("返回");
        contentPane.add(Backbutton);
        Backbutton.setBounds(15, 10, 60, 30);
        Backbutton.addActionListener(e -> {
            ShowMessage ShowMessagePage = new ShowMessage();
            ShowMessagePage.setVisible(true);
            this.dispose();
        });

        //=== 发布人标签设置 ===
        ContactText.setText("发布人");
        ContactText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(ContactText);
        ContactText.setBounds(15, 60, 60, 30);

        //=== 发布人输入框设置（只读）===
        textField3 = new JTextField();
        textField3.setEditable(false);  // 设置为不可编辑（只读）
        textField3.setBackground(Color.WHITE); // 保持白色背景
        contentPane.add(textField3);
        textField3.setBounds(80, 60, 270, 30);

        //=== 内容标签设置 ===
        ContentText.setText("内容");
        ContentText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(ContentText);
        ContentText.setBounds(20, 100, 60, 30);

        //=== 多行文本区域设置（只读）===
        textArea = new JTextArea();
        textArea.setEditable(false);   // 设置为不可编辑（只读）
        textArea.setLineWrap(true);    // 启用自动换行
        textArea.setWrapStyleWord(true);  // 按单词边界换行（更美观）
        textArea.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        textArea.setBackground(Color.WHITE); // 保持白色背景

        //=== 滚动面板设置 ===
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(80, 100, 270, 160);  // 设置位置和大小
        // 设置垂直滚动条策略：需要时显示
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(scrollPane);

        // 添加示例文本（用于演示）
        textArea.setText("这里是通知内容区域...\n可以显示多行文本\n当内容超出时会自动显示滚动条\n\n" +
                "1. 第一条通知\n2. 第二条通知\n3. 第三条通知\n".repeat(5));

        //=== 计算并设置内容面板的首选大小 ===
        Dimension preferredSize = new Dimension();
        // 遍历所有组件，计算需要的最小尺寸
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
            Rectangle bounds = contentPane.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
        }
        // 考虑边框的内边距
        Insets insets = contentPane.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        contentPane.setMinimumSize(preferredSize);
        contentPane.setPreferredSize(preferredSize);

        // 窗口相对于所有者居中（null表示屏幕中央）
        setLocationRelativeTo(getOwner());
    }

    /**
     * 初始化框架设置
     */
    private void initFrame() {
        // 初始化所有组件
        Title = new JLabel();
        Backbutton = new JButton();
        ContactText = new JLabel();
        ContentText = new JLabel();
        textField3 = new JTextField();
        textArea = new JTextArea();   // 多行文本区域
        scrollPane = new JScrollPane(); // 滚动面板

        // 设置窗口属性
        this.setBounds(100, 100, 400, 350);  // 窗口位置和大小
        this.getContentPane().setLayout(null); // 使用绝对布局
        this.setResizable(false);              // 禁止调整窗口大小
    }

    /**
     * 主方法：启动应用程序
     */
    public static void main(String[] args) {
        // 使用事件分发线程创建并显示GUI
        SwingUtilities.invokeLater(NotificationModule::new);
    }
}