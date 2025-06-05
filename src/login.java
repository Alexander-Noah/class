import javax.swing.*;
import java.awt.*;
/*
 * Created by JFormDesigner on Thu Jun 05 09:52:36 CST 2025
 */

/**
 * @author zheng
 */
public class login extends JFrame {
    public login() {
        //初始化界面
        initFrame();
        //初始化组件
        initView();
        //显示界面
        this.setVisible(true);

    }

    // 在 login 类中定义一个 User 数组作为模拟数据库
    private User[] users = {
            new User("student01", "123456", "学生", "计算机科学与技术1班"),
            new User("teacher01", "abcdef", "教师", "软件工程1班"),
            new User("admin", "admin123", "管理员", "网络工程1班")
    };

    private void initView() {
        //---- title ----
        title.setText("疫情防控登入系统");
        title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        this.getContentPane().add(title);
        title.setBounds(155, 20, 225, 30);

        //---- UserTxt ----
        UserTxt.setText("账号");
        UserTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(UserTxt);
        UserTxt.setBounds(85, 70, 52, 35);

        //---- PassWordTxt ----
        PassWordTxt.setText("密码");
        PassWordTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(PassWordTxt);
        PassWordTxt.setBounds(80, 115, 54, 35);

        //---- LoginButton ----
        LoginButton.setText("登入");
        LoginButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        this.getContentPane().add(LoginButton);
        LoginButton.setBounds(274, 266, 90, 40);
        this.getContentPane().add(UserField);
        UserField.setBounds(150, 80, 227, 30);
        this.getContentPane().add(passwordField);
        passwordField.setBounds(150, 123, 227, 30);

        // 按下登录按钮事件
        LoginButton.addActionListener(e -> loginAction());

        //---- RegisterButton ----
        RegisterButton.setText("注册");
        RegisterButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        this.getContentPane().add(RegisterButton);
        RegisterButton.setBounds(127, 265, 90, 40);


        this.getContentPane().add(ChooseID);
        ChooseID.setBounds(150, 170, 222, ChooseID.getPreferredSize().height);

        //---- IDTxt ----
        IDTxt.setText("身份");
        IDTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        this.getContentPane().add(IDTxt);
        IDTxt.setBounds(85, 167, 42, 28);

        //---- ClassTxt ----
        ClassTxt.setText("班级");
        ClassTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        this.getContentPane().add(ClassTxt);
        ClassTxt.setBounds(85, 218, 42, 28);


        this.getContentPane().add(ChooseClass);
        ChooseClass.setBounds(150, 220, 222,28);

        this.getContentPane().setPreferredSize(new Dimension(460, 365));

        // 添加数据到身份下拉框
        ChooseID.addItem("学生");
        ChooseID.addItem("教师");
        ChooseID.addItem("管理员");

        // 添加数据到班级下拉框
        ChooseClass.addItem("计算机科学与技术1班");
        ChooseClass.addItem("计算机科学与技术2班");
        ChooseClass.addItem("软件工程1班");
        ChooseClass.addItem("软件工程2班");
        ChooseClass.addItem("网络工程1班");

    }

    private void initFrame() {
        //标题
        title = new JLabel();
        //账号文本
        UserTxt = new JLabel();
        //密码文本
        PassWordTxt = new JLabel();
        //登入按钮
        LoginButton = new JButton();
        //账号输入框
        UserField = new JTextField();
        //密码输入框
        passwordField = new JPasswordField();
        //注册按钮
        RegisterButton = new JButton();
        //身份选择框
        ChooseID = new JComboBox();
        //身份文本
        IDTxt= new JLabel();
        //班级文本
        ClassTxt = new JLabel();
        //班级选择框
        ChooseClass = new JComboBox();
        //设置界面大小
        this.setBounds(100, 100, 450, 400);
        //取消默认的布局
        this.getContentPane().setLayout(null);


    }

    private void loginAction() {
        //从输入框中获取输入的用户名
        String username =UserField.getText().trim();
        //从输入框中获取输入的密码
        String password = new String(passwordField.getPassword()).trim();
        //获取选择的身份
        String role = (String) ChooseID.getSelectedItem();
        //获取选择的班级
        String clazz = (String) ChooseClass.getSelectedItem();

        boolean success = false;

        for (User user : users) {
            if (user.getUsername().equals(username) &&
                    user.getPassword().equals(password) &&
                    user.getRole().equals(role) &&
                    user.getClazz().equals(clazz)) {
                success = true;
                break;
            }
        }

        if (success) {
            JOptionPane.showMessageDialog(this, "登录成功！");
            //if(role)
            //new UI();
        } else {
            JOptionPane.showMessageDialog(this, "账号、密码或身份信息错误！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title;
    private JLabel UserTxt;
    private JLabel PassWordTxt;
    private JButton LoginButton;
    private JTextField UserField;
    private JPasswordField passwordField;
    private JButton RegisterButton;
    private JComboBox ChooseID;
    private JLabel IDTxt;
    private JLabel ClassTxt;
    private JComboBox ChooseClass;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login());
    }
}