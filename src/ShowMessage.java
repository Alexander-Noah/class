import java.awt.*;
import javax.swing.*;

/**
 * @author zheng
 * 基本信息显示页面！！！
 * 基本信息显示页面！！！
 * 基本信息显示页面！！！
 */
public class ShowMessage extends JFrame {
    //把变量放这，方便调用
    private JLabel Title;
    private JLabel StudentID;
    private JLabel StudentName;
    private JLabel StudentGender;
    private JLabel StudentAge;
    private JLabel Discipline;
    private JLabel StudentClass;
    private JLabel EnrollmentDate;
    private JLabel IdDisplayBox;
    private JLabel NameDisplayBox;
    private JLabel GenderDisplayBox;
    private JLabel AgeDisplayBox;
    private JLabel DisciplineDisplayBox;
    private JLabel ClassDisplayBox;
    private JLabel EnrollmentDateDisplayBox;
    private JButton CourseInformation;
    private JButton notice;


    public ShowMessage() {
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
        //文本
        setupComponent(Title, "基本信息", 180, 12, 133, 30, 24);
        setupComponent(StudentID, "学号:", 108, 50, 60, 50, 20);
        setupComponent(StudentName, "姓名:", 108, 100, 60, 50, 20);
        setupComponent(StudentGender, "性别:", 108, 150, 60, 50, 20);
        setupComponent(StudentAge, "年龄:", 108, 200, 60, 45, 20);
        setupComponent(Discipline, "专业:", 108, 250, 60, 45, 20);
        setupComponent(StudentClass, "班级:", 108, 300, 70, 45, 20);
        setupComponent(EnrollmentDate, "入学日期:", 68, 350, 115, 45, 20);

        //显示框
        setupDisplayBox(IdDisplayBox, "20230001", 176, 62, 235, 30);
        setupDisplayBox(NameDisplayBox, "张三", 176, 112, 235, 30);
        setupDisplayBox(GenderDisplayBox, "男", 176, 162, 235, 30);
        setupDisplayBox(AgeDisplayBox, "20", 176, 212, 235, 30);
        setupDisplayBox(DisciplineDisplayBox, "计算机科学与技术", 176, 262, 235, 30);
        setupDisplayBox(ClassDisplayBox, "CS-2023-1班", 176, 312, 235, 30);
        setupDisplayBox(EnrollmentDateDisplayBox, "2023-09-01", 176, 362, 235, 30);

        // 设置按钮
        setupButton(CourseInformation, "课程信息", 120, 412, 120, 35);
        setupButton(notice, "通知", 300, 412, 120, 36);

        CourseInformation.addActionListener(e -> {
            // 创建课程信息页面
            Curriculum curriculumPage = new Curriculum();
            curriculumPage.setVisible(true);
            this.dispose(); // 关闭当前窗口（可选）
        });
        notice.addActionListener(e -> {
            // 创建通知页面
            NotificationModule NotificationModulePage = new NotificationModule();
            NotificationModulePage.setVisible(true);
            this.dispose(); // 关闭当前窗口（可选）
        });

//        pack();
        setLocationRelativeTo(getOwner());
    }

    private void setupComponent(JComponent comp, String text, int x, int y, int w, int h, int fontSize) {
        if (comp instanceof JLabel) {
            ((JLabel) comp).setText(text);
        } else if (comp instanceof JButton) {
            ((JButton) comp).setText(text);
        }
        comp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, fontSize));
        comp.setBounds(x, y, w, h);
        getContentPane().add(comp);
    }

    private void setupDisplayBox(JLabel box, String text, int x, int y, int w, int h) {
        box.setText(text);
        box.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        box.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        box.setBounds(x, y, w, h);
        getContentPane().add(box);
    }

    // 辅助方法：统一设置按钮
    private void setupButton(JButton button, String text, int x, int y, int w, int h) {
        button.setText(text);
        button.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        button.setBounds(x, y, w, h);
        getContentPane().add(button);
    }

    private void initFrame() {
        //标题
        Title = new JLabel();
        //学号
        StudentID = new JLabel();
        //学生姓名
        StudentName = new JLabel();
        //学生性别
        StudentGender = new JLabel();
        //学生年龄
        StudentAge = new JLabel();
        //学生专业
        Discipline = new JLabel();
        //学生班级
        StudentClass = new JLabel();
        //入学日期
        EnrollmentDate = new JLabel();
        //学生学号显示框
        IdDisplayBox = new JLabel();
        //学生姓名显示框
        NameDisplayBox = new JLabel();
        //学生性别显示框
        GenderDisplayBox = new JLabel();
        //学生年龄显示框
        AgeDisplayBox = new JLabel();
        //学生专业显示框
        DisciplineDisplayBox = new JLabel();
        //学生班级显示框
        ClassDisplayBox = new JLabel();
        //学生入学日期显示框
        EnrollmentDateDisplayBox = new JLabel();
        //课程信息按钮
        CourseInformation = new JButton();
        //教师通知按钮
        notice = new JButton();
        //设置界面大小
        this.setBounds(100, 100, 500, 500);
        //取消默认的布局
        this.getContentPane().setLayout(null);
        //禁止调整界面大小
        this.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShowMessage frame = new ShowMessage();
            frame.setVisible(true);
        });
    }
}
