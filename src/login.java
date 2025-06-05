import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 05 09:52:36 CST 2025
 */

/**
 * @author zheng
 */
public class login extends JFrame {
    public login() {
        initComponents();

        // 添加数据到身份下拉框
        comboBox1.addItem("学生");
        comboBox1.addItem("教师");
        comboBox1.addItem("管理员");

        // 添加数据到班级下拉框
        comboBox2.addItem("计算机科学与技术1班");
        comboBox2.addItem("计算机科学与技术2班");
        comboBox2.addItem("软件工程1班");
        comboBox2.addItem("软件工程2班");
        comboBox2.addItem("网络工程1班");

        this.setBounds(100, 100, 450, 400);
        this.setVisible(true);
       /*
        // 从数据库获取身份选项
        List<String> roles = database.getRoles();
        for (String role : roles) {
        comboBox1.addItem(role);
        }

        // 从数据库获取班级选项
        List<String> classes = database.getClasses();
        for (String cls : classes) {
            comboBox2.addItem(cls);
        }
        */
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        title = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button2 = new JButton();
        comboBox1 = new JComboBox();
        label4 = new JLabel();
        label5 = new JLabel();
        comboBox2 = new JComboBox();

        //======== tab1 ========
        {
            this.getContentPane().setLayout(null);

            //---- label1 ----
            title.setText("疫情防控登入系统");
            title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
            this.getContentPane().add(title);
            title.setBounds(155, 18, 225, 30);

            //---- label2 ----
            label2.setText("账号");
            label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            this.getContentPane().add(label2);
            label2.setBounds(85, 70, 52, 35);

            //---- label3 ----
            label3.setText("密码");
            label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
            this.getContentPane().add(label3);
            label3.setBounds(80, 115, 54, 35);

            //---- button1 ----
            button1.setText("登入");
            button1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            this.getContentPane().add(button1);
            button1.setBounds(274, 266, 95, 45);
            this.getContentPane().add(textField1);
            textField1.setBounds(150, 70, 227, textField1.getPreferredSize().height);
            this.getContentPane().add(passwordField1);
            passwordField1.setBounds(150, 115, 227, passwordField1.getPreferredSize().height);

            //---- button2 ----
            button2.setText("注册");
            button2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            this.getContentPane().add(button2);
            button2.setBounds(127, 265, 90, 45);
            this.getContentPane().add(comboBox1);
            comboBox1.setBounds(150, 165, 222, comboBox1.getPreferredSize().height);

            //---- label4 ----
            label4.setText("身份");
            label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            this.getContentPane().add(label4);
            label4.setBounds(85, 167, 42, 28);

            //---- label5 ----
            label5.setText("班级");
            label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
            this.getContentPane().add(label5);
            label5.setBounds(85, 218, 43, 28);
            this.getContentPane().add(comboBox2);
            comboBox2.setBounds(150, 213, 222, comboBox2.getPreferredSize().height);

            this.getContentPane().setPreferredSize(new Dimension(460, 365));
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel title;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button2;
    private JComboBox comboBox1;
    private JLabel label4;
    private JLabel label5;
    private JComboBox comboBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new login());
    }
}