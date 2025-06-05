import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Thu Jun 05 22:27:43 CST 2025
 */

/**
 * @author zheng
 * 废弃代码，勿动！！！
 * 废弃代码，勿动！！！
 * 废弃代码，勿动！！！
 * 废弃代码，勿动！！！
 * 废弃代码，勿动！！！
 */
public class Enroll extends JFrame {
    public Enroll() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        //标题文本
        Title = new JLabel();
        //账号文本
        TextUser = new JLabel();
        //密码文本
        PassworldText = new JLabel();
        //确认密码文本
        PassworldTest2 = new JLabel();
        //账号输入
        UserField = new JTextField();
        //密码
        passwordText = new JPasswordField();
        //确认密码
        passwordText2 = new JPasswordField();
        //注册按钮
        RegisterButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- Title ----
        Title.setText("疫情防控注册系统（学生端）");
        Title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
        contentPane.add(Title);
        Title.setBounds(145, 12, 300, 38);

        //---- TextUser ----
        TextUser.setText("学号");
        TextUser.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(TextUser);
        TextUser.setBounds(83, 70, 46, 30);

        //---- PassworldText ----
        PassworldText.setText("密码");
        PassworldText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(PassworldText);
        PassworldText.setBounds(84, 120, 46, 30);

        //---- passwordText ----
        PassworldTest2.setText("确认密码");
        PassworldTest2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(PassworldTest2);
        PassworldTest2.setBounds(49, 169, 81, 30);
        contentPane.add(UserField);
        UserField.setBounds(151, 65, 280, UserField.getPreferredSize().height);
        contentPane.add(passwordText);
        passwordText.setBounds(151, 115, 280, passwordText.getPreferredSize().height);
        contentPane.add(passwordText2);
        passwordText2.setBounds(150, 166, 280, passwordText2.getPreferredSize().height);

        //---- RegisterButton ----
        RegisterButton.setText("注册");
        RegisterButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(RegisterButton);
        RegisterButton.setBounds(162, 231, 240, RegisterButton.getPreferredSize().height);

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
    private JLabel Title;
    private JLabel TextUser;
    private JLabel PassworldText;
    private JLabel PassworldTest2;
    private JTextField UserField;
    private JPasswordField passwordText;
    private JPasswordField passwordText2;
    private JButton RegisterButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Enroll());
    }
}

