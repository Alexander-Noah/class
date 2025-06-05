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
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
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

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u75ab\u60c5\u9632\u63a7\u767b\u5165\u7cfb\u7edf");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        contentPane.add(label1);
        label1.setBounds(155, 18, 225, 30);

        //---- label2 ----
        label2.setText("\u8d26\u53f7");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label2);
        label2.setBounds(85, 70, 52, 35);

        //---- label3 ----
        label3.setText("\u5bc6\u7801");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        contentPane.add(label3);
        label3.setBounds(80, 115, 54, 35);

        //---- button1 ----
        button1.setText("\u767b\u5165");
        button1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(button1);
        button1.setBounds(274, 266, 95, 45);
        contentPane.add(textField1);
        textField1.setBounds(150, 70, 227, textField1.getPreferredSize().height);
        contentPane.add(passwordField1);
        passwordField1.setBounds(150, 115, 227, passwordField1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        button2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(button2);
        button2.setBounds(127, 265, 90, 45);
        contentPane.add(comboBox1);
        comboBox1.setBounds(150, 160, 222, comboBox1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u8eab\u4efd");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label4);
        label4.setBounds(85, 167, 42, 28);

        //---- label5 ----
        label5.setText("\u73ed\u7ea7");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        contentPane.add(label5);
        label5.setBounds(85, 218, 43, 28);
        contentPane.add(comboBox2);
        comboBox2.setBounds(150, 210, 222, comboBox2.getPreferredSize().height);

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
    private JLabel label1;
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
}
