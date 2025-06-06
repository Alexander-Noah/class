import javax.swing.*;
import java.awt.*;

/**
 * @author zheng
 * 登入页面
 */

public class login extends JFrame {

    //把变量放这，方便调用
    private JLabel title;
    private JLabel UserTxt;
    private JLabel PassWordTxt;
    private JButton LoginButton;
    private JTextField UserField;
    private JPasswordField passwordField;
    private JButton RegisterButton;
    private JComboBox<String> ChooseID;
    private JLabel IDTxt;
    private JLabel ClassTxt;
    private JComboBox<String> ChooseClass;


    public login() {
        //初始化界面
        initFrame();
        //初始化组件
        initView();
        //窗口居中显示
        this.setLocationRelativeTo(null);
        //关闭窗口程序停止
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示界面
        this.setVisible(true);
    }

    // 在 login 类中定义一个 User 数组作为模拟数据库
    private final User[] users = {
            new User("student01", "123456", "学生", "计算机科学与技术1班"),
            new User("teacher01", "abcdef", "教师", "软件工程1班"),
            new User("admin", "admin123", "管理员", "网络工程1班")
    };

    private void initView() {
        //---- title ----
        title.setText("疫情防控登入系统");
        title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        this.getContentPane().add(title);
        title.setBounds(115, 20, 225, 30);

        //---- UserTxt ----
        UserTxt.setText("账号");
        UserTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(UserTxt);
        UserTxt.setBounds(75, 70, 52, 28);

        //---- UserField ----
        this.getContentPane().add(UserField);
        UserField.setBounds(150, 70, 225, 28);

        //---- PassWordTxt ----
        PassWordTxt.setText("密码");
        PassWordTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(PassWordTxt);
        PassWordTxt.setBounds(75, 115, 54, 28);

        //---- PassWordField ----
        this.getContentPane().add(passwordField);
        passwordField.setBounds(150, 115, 225,28);

        //---- ChooseID ----
        this.getContentPane().add(ChooseID);
        ChooseID.setBounds(150, 160, 225, 28);

        //---- IDTxt ----
        IDTxt.setText("身份");
        IDTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(IDTxt);
        IDTxt.setBounds(75, 160, 42, 28);

        //---- ClassTxt ----
        ClassTxt.setText("班级");
        ClassTxt.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(ClassTxt);
        ClassTxt.setBounds(75, 205, 42, 28);

        //---- ChooseClass ----
        this.getContentPane().add(ChooseClass);
        ChooseClass.setBounds(150, 205, 225,28);

        //---- LoginButton ----
        LoginButton.setText("登入");
        LoginButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(LoginButton);
        LoginButton.setBounds(255,255 , 90, 35);
        LoginButton.addActionListener(e -> loginAction());

        //---- RegisterButton ----
        RegisterButton.setText("注册");
        RegisterButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        this.getContentPane().add(RegisterButton);
        RegisterButton.setBounds(105,255 , 90, 35);
        RegisterButton.addActionListener(e -> RegisterAction());

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
        ChooseID = new JComboBox<>();
        //身份文本
        IDTxt= new JLabel();
        //班级文本
        ClassTxt = new JLabel();
        //班级选择框
        ChooseClass = new JComboBox<>();
        //设置界面大小
        this.setBounds(100, 100, 450, 350);
        //取消默认的布局
        this.getContentPane().setLayout(null);
        //禁止调整界面大小
        this.setResizable(false);

    }

    private void loginAction() {
        //登录功能
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
        } else {
            JOptionPane.showMessageDialog(this, "账号、密码或身份信息错误！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void RegisterAction() {
        //注册功能

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off


}