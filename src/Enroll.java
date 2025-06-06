import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 05 22:27:43 CST 2025
 */

/**
 * @author zheng
 * 注册页面
 * 注册页面
 * 注册页面
 * 注册页面
 */
public class Enroll extends JFrame {
    //把变量放这，方便调用
    private JLabel Title;
    private JLabel TextUser;
    private JLabel PassworldText;
    private JLabel PassworldTest2;
    private JTextField UserField;
    private JPasswordField passwordText;
    private JPasswordField passwordText2;
    private JButton RegisterButton;
    private JLabel ClassTxt;
    private JComboBox<String> ChooseClass;
    private JComboBox<String> ChooseID;
    private JLabel IDTxt;
    public Enroll() {
        //初始化界面
        initFrame();
        //初始化组件
        initComponents();
        //窗口居中显示
        this.setLocationRelativeTo(null);
        //关闭窗口程序停止
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示界面
        this.setVisible(true);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off


        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Title ----
        Title.setText("疫情防控注册系统");
        Title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(Title);
        Title.setBounds(145, 10, 300, 38);

        //---- TextUser ----
        TextUser.setText("学号");
        TextUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(TextUser);
        TextUser.setBounds(84, 65, 46, 30);

        //---- PassworldText ----
        PassworldText.setText("密码");
        PassworldText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(PassworldText);
        PassworldText.setBounds(84, 115, 46, 30);

        //---- passwordText ----
        PassworldTest2.setText("确认密码");
        PassworldTest2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(PassworldTest2);
        PassworldTest2.setBounds(49, 165, 81, 30);

        //----UserField----
        contentPane.add(UserField);
        UserField.setBounds(145, 65, 280, 30);

        //----passwordText----
        contentPane.add(passwordText);
        passwordText.setBounds(145, 115, 280, 30);

        //----passwordText2----
        contentPane.add(passwordText2);
        passwordText2.setBounds(145, 165, 280, 30);

        //---- IDTxt ----
        IDTxt.setText("身份");
        IDTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(IDTxt);
        IDTxt.setBounds(75, 215, 42, 28);

        //---- ChooseID ----
        this.getContentPane().add(ChooseID);
        ChooseID.setBounds(150, 215, 225, 28);
        // 添加数据到身份下拉框
        ChooseID.addItem("学生");
        ChooseID.addItem("教师");

        //----ClassTxt----
        ClassTxt.setText("班级");
        ClassTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(ClassTxt);
        ClassTxt.setBounds(84, 265, 42, 28);

        //---- ChooseClass ----
        this.getContentPane().add(ChooseClass);
        ChooseClass.setBounds(151, 265, 280,30);
        // 添加数据到班级下拉框
        ChooseClass.addItem("计算机科学与技术1班");
        ChooseClass.addItem("计算机科学与技术2班");
        ChooseClass.addItem("软件工程1班");
        ChooseClass.addItem("软件工程2班");
        ChooseClass.addItem("网络工程1班");

        //---- RegisterButton ----
        RegisterButton.setText("注册");
        RegisterButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(RegisterButton);
        RegisterButton.setBounds(162, 315, 240, RegisterButton.getPreferredSize().height);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    private void initFrame(){
        //标题文本
        Title = new JLabel();
        //账号文本
        TextUser = new JLabel();
        //账号输入
        UserField = new JTextField();
        //密码文本
        PassworldText = new JLabel();
        //密码输入
        passwordText = new JPasswordField();
        //确认密码文本
        PassworldTest2 = new JLabel();
        //确认密码输入
        passwordText2 = new JPasswordField();
        //身份选择框
        ChooseID = new JComboBox<>();
        //身份文本
        IDTxt= new JLabel();
        //班级文本
        ClassTxt = new JLabel();
        //班级选择框
        ChooseClass = new JComboBox<>();
        //注册按钮
        RegisterButton = new JButton();
        //设置界面大小
        this.setBounds(100, 100, 450, 350);
        //取消默认的布局
        this.getContentPane().setLayout(null);
        //禁止调整界面大小
        this.setResizable(false);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Enroll());
    }
}

