import java.awt.*;
import javax.swing.*;
/**
 * @author zheng
 * 课程信息模块！！！
 * 课程信息模块！！！
 * 课程信息模块！！！
 * 课程信息模块！！！
 */
public class Curriculum extends JFrame {
    //变量调用
    private JLabel CourseSchedule;
    private JLabel CourseTitleText;
    private JLabel InstructorText;
    private JLabel ClassRoomText;
    private JLabel ScheduleText;
    private JButton Backtopreviouslevel;
    //课程显示框
    private JLabel CourseDisplayBox1;
    private JLabel CourseDisplayBox2;
    private JLabel CourseDisplayBox3;
    private JLabel CourseDisplayBox4;
    private JLabel CourseDisplayBox5;
    //授课老师显示框
    private JLabel InstructordDisplayBox1;
    private JLabel InstructordDisplayBox2;
    private JLabel InstructordDisplayBox3;
    private JLabel InstructordDisplayBox4;
    private JLabel InstructordDisplayBox5;
    //时间安排显示框
    private JLabel ScheduleDisplayBox1;
    private JLabel ScheduleDisplayBox2;
    private JLabel ScheduleDisplayBox3;
    private JLabel ScheduleDisplayBox4;
    private JLabel ScheduleDisplayBox5;
    //教室显示框
    private JLabel ClassroomDisplayFrame1;
    private JLabel ClassroomDisplayFrame2;
    private JLabel ClassroomDisplayFrame3;
    private JLabel ClassroomDisplayFrame4;
    private JLabel ClassroomDisplayFrame5;

    private JComboBox comboBox1;

    public Curriculum() {
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

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- CourseSchedule ----
        CourseSchedule = new JLabel();
        CourseSchedule.setText("课程表");
        CourseSchedule.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 24));
        getContentPane().add(CourseSchedule);
        CourseSchedule.setBounds(248, 10, 90, 40);

        // 课程名称文本
        CourseTitleText = new JLabel();
        CourseTitleText.setText("课程名称");
        CourseTitleText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        getContentPane().add(CourseTitleText);
        CourseTitleText.setBounds(36,60, 90, 40);

        // 授课老师文本
        InstructorText = new JLabel();
        InstructorText.setText("授课老师");
        InstructorText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        getContentPane().add(InstructorText);
        InstructorText.setBounds(170, 60, 90, 40);

        // 上课教室文本
        ClassRoomText = new JLabel();
        ClassRoomText.setText("教室");
        ClassRoomText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        getContentPane().add(ClassRoomText);
        ClassRoomText.setBounds(438, 60, 90, 40);

        // 时间安排文本
        ScheduleText = new JLabel();
        ScheduleText.setText("时间安排");
        ScheduleText.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
        getContentPane().add(ScheduleText);
        ScheduleText.setBounds(304, 60, 90, 40);

        // 返回按钮
        Backtopreviouslevel = new JButton();
        Backtopreviouslevel.setText("返回");
        getContentPane().add(Backtopreviouslevel);
        Backtopreviouslevel.setBounds(30,10,75,30);
        Backtopreviouslevel.addActionListener(e -> {
            // 创建课程信息页面
            ShowMessage ShowMessagePage = new ShowMessage();
            ShowMessagePage.setVisible(true);
            this.dispose(); // 关闭当前窗口（可选）
        });

        // 课程显示框1
        CourseDisplayBox1 = new JLabel();
        CourseDisplayBox1.setText("高等数学");
        CourseDisplayBox1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(CourseDisplayBox1);
        CourseDisplayBox1.setBounds(36, 110, 100, CourseDisplayBox1.getPreferredSize().height);

        // 课程显示框2
        CourseDisplayBox2 = new JLabel();
        CourseDisplayBox2.setText("Java实战");
        CourseDisplayBox2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(CourseDisplayBox2);
        CourseDisplayBox2.setBounds(36, 160, 100, CourseDisplayBox2.getPreferredSize().height);

        // 课程显示框3
        CourseDisplayBox3 = new JLabel();
        CourseDisplayBox3.setText("java基础");
        CourseDisplayBox3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(CourseDisplayBox3);
        CourseDisplayBox3.setBounds(36, 210, 100, CourseDisplayBox3.getPreferredSize().height);

        // 课程显示框4
        CourseDisplayBox4 = new JLabel();
        CourseDisplayBox4.setText("数据库基础");
        CourseDisplayBox4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(CourseDisplayBox4);
        CourseDisplayBox4.setBounds(36, 260, 100, CourseDisplayBox4.getPreferredSize().height);

        // 课程显示框5
        CourseDisplayBox5 = new JLabel();
        CourseDisplayBox5.setText("大学英语");
        CourseDisplayBox5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(CourseDisplayBox5);
        CourseDisplayBox5.setBounds(36, 310, 100, CourseDisplayBox5.getPreferredSize().height);

        // 授课老师显示框1
        InstructordDisplayBox1 = new JLabel();
        InstructordDisplayBox1.setText("李教授");
        InstructordDisplayBox1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(InstructordDisplayBox1);
        InstructordDisplayBox1.setBounds(170, 110, 100, InstructordDisplayBox1.getPreferredSize().height);

        // 授课老师显示框2
        InstructordDisplayBox2 = new JLabel();
        InstructordDisplayBox2.setText("欧阳教授");
        InstructordDisplayBox2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(InstructordDisplayBox2);
        InstructordDisplayBox2.setBounds(170, 160, 100, InstructordDisplayBox2.getPreferredSize().height);

        // 授课老师显示框3
        InstructordDisplayBox3 = new JLabel();
        InstructordDisplayBox3.setText("邓教授");
        InstructordDisplayBox3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(InstructordDisplayBox3);
        InstructordDisplayBox3.setBounds(170, 210, 100, InstructordDisplayBox3.getPreferredSize().height);

        // 授课老师显示框4
        InstructordDisplayBox4 = new JLabel();
        InstructordDisplayBox4.setText("王教授");
        InstructordDisplayBox4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(InstructordDisplayBox4);
        InstructordDisplayBox4.setBounds(170, 260, 100, InstructordDisplayBox4.getPreferredSize().height);

        // 授课老师显示框5
        InstructordDisplayBox5 = new JLabel();
        InstructordDisplayBox5.setText("蒋教授");
        InstructordDisplayBox5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(InstructordDisplayBox5);
        InstructordDisplayBox5.setBounds(170, 310, 100, InstructordDisplayBox5.getPreferredSize().height);

        // 时间安排显示框1
        ScheduleDisplayBox1 = new JLabel();
        ScheduleDisplayBox1.setText("1-2节");
        ScheduleDisplayBox1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ScheduleDisplayBox1);
        ScheduleDisplayBox1.setBounds(304, 110, 100, ScheduleDisplayBox1.getPreferredSize().height);

        // 时间安排显示框2
        ScheduleDisplayBox2 = new JLabel();
        ScheduleDisplayBox2.setText("3-4节");
        ScheduleDisplayBox2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ScheduleDisplayBox2);
        ScheduleDisplayBox2.setBounds(304, 160, 100, ScheduleDisplayBox2.getPreferredSize().height);

        // 时间安排显示框3
        ScheduleDisplayBox3 = new JLabel();
        ScheduleDisplayBox3.setText("5-6节");
        ScheduleDisplayBox3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ScheduleDisplayBox3);
        ScheduleDisplayBox3.setBounds(304, 210, 100, ScheduleDisplayBox3.getPreferredSize().height);

        // 时间安排显示框4
        ScheduleDisplayBox4 = new JLabel();
        ScheduleDisplayBox4.setText("7-8节");
        ScheduleDisplayBox4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ScheduleDisplayBox4);
        ScheduleDisplayBox4.setBounds(304, 260, 100, ScheduleDisplayBox4.getPreferredSize().height);

        // 时间安排显示框5
        ScheduleDisplayBox5 = new JLabel();
        ScheduleDisplayBox5.setText("9-10节");
        ScheduleDisplayBox5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ScheduleDisplayBox5);
        ScheduleDisplayBox5.setBounds(304, 310, 100, ScheduleDisplayBox5.getPreferredSize().height);

        // 教室显示框1
        ClassroomDisplayFrame1 = new JLabel();
        ClassroomDisplayFrame1.setText("301");
        ClassroomDisplayFrame1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ClassroomDisplayFrame1);
        ClassroomDisplayFrame1.setBounds(438, 110, 100, ClassroomDisplayFrame1.getPreferredSize().height);

        // 教室显示框2
        ClassroomDisplayFrame2 = new JLabel();
        ClassroomDisplayFrame2.setText("204");
        ClassroomDisplayFrame2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ClassroomDisplayFrame2);
        ClassroomDisplayFrame2.setBounds(438, 160, 100, ClassroomDisplayFrame2.getPreferredSize().height);

        // 教室显示框3
        ClassroomDisplayFrame3 = new JLabel();
        ClassroomDisplayFrame3.setText("102");
        ClassroomDisplayFrame3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ClassroomDisplayFrame3);
        ClassroomDisplayFrame3.setBounds(438, 210, 100, ClassroomDisplayFrame3.getPreferredSize().height);

        // 教室显示框4
        ClassroomDisplayFrame4 = new JLabel();
        ClassroomDisplayFrame4.setText("205");
        ClassroomDisplayFrame4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ClassroomDisplayFrame4);
        ClassroomDisplayFrame4.setBounds(438, 260, 100, ClassroomDisplayFrame4.getPreferredSize().height);

        // 教室显示框5
        ClassroomDisplayFrame5 = new JLabel();
        ClassroomDisplayFrame5.setText("501");
        ClassroomDisplayFrame5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        getContentPane().add(ClassroomDisplayFrame5);
        ClassroomDisplayFrame5.setBounds(438, 310, 100, ClassroomDisplayFrame5.getPreferredSize().height);

        // 下拉框
        comboBox1 = new JComboBox();
        getContentPane().add(comboBox1);
        comboBox1.setBounds(400, 10, 100, 30);
        comboBox1.addItem("第十周");
        comboBox1.addItem("第十一周");
        comboBox1.addItem("第十二周");
        comboBox1.addItem("第十三周");

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
//        pack();
        setLocationRelativeTo(getOwner());
    }

    private void initFrame(){
        //标题
        CourseSchedule = new JLabel();
        //课程名称文本
        CourseTitleText = new JLabel();
        //授课老师文本
        InstructorText = new JLabel();
        //上课教师文本
        ClassRoomText = new JLabel();
        //时间安排文本
        ScheduleText = new JLabel();
        //返回按钮
        Backtopreviouslevel = new JButton();
        //课程显示框
        CourseDisplayBox1 = new JLabel();
        CourseDisplayBox2 = new JLabel();
        CourseDisplayBox3 = new JLabel();
        CourseDisplayBox4 = new JLabel();
        CourseDisplayBox5 = new JLabel();
        //授课老师显示框
        InstructordDisplayBox1 = new JLabel();
        InstructordDisplayBox2 = new JLabel();
        InstructordDisplayBox3 = new JLabel();
        InstructordDisplayBox4 = new JLabel();
        InstructordDisplayBox5 = new JLabel();
        //时间安排显示框
        ScheduleDisplayBox1 = new JLabel();
        ScheduleDisplayBox2 = new JLabel();
        ScheduleDisplayBox3 = new JLabel();
        ScheduleDisplayBox4 = new JLabel();
        ScheduleDisplayBox5 = new JLabel();
        //教室显示框
        ClassroomDisplayFrame1 = new JLabel();
        ClassroomDisplayFrame2 = new JLabel();
        ClassroomDisplayFrame3 = new JLabel();
        ClassroomDisplayFrame4 = new JLabel();
        ClassroomDisplayFrame5 = new JLabel();
        comboBox1 = new JComboBox();
        //设置界面大小
        this.setBounds(100, 100, 530, 400);
        //取消默认的布局
        this.getContentPane().setLayout(null);
        //禁止调整界面大小
        this.setResizable(false);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Curriculum frame = new Curriculum();
        });
    }
}
