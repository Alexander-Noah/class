import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class UI extends JFrame implements ActionListener {

    int ID;

    //学生查看信息
    JMenuItem ShowMessage;
    //学生请假
    JMenuItem ApplyHoliday;
    //教师发布信息
    JMenuItem ReleaseMessage;
    //教师修改信息
    JMenuItem ReviseMessage;
    //教师审批学生请假
    JMenuItem ApprovalHoliday;

    //接收id，0表示学生，1表示教师，2表示管理员
    public UI(int ID){
        this.ID = ID;
        init();
        this.setVisible(true);
    }

    public void init(){
        //取消原有的布局
        this.setLayout(null);
        //设置置顶
        this.setAlwaysOnTop(true);
        //信息的菜单选项
        JMenu message =new JMenu("信息");
        //请假的菜单选项
        JMenu Holiday=new JMenu("请假");
        //特有的功能
        if(ID==0){
            //在信息选项，学生只能查看信息
            ShowMessage =new JMenuItem("查看信息");
            ShowMessage.addActionListener(this);
            message.add(ShowMessage);
            //在请假选项中，学生只能申请请假并查看状态
            ApplyHoliday =new JMenuItem("学生请假");
            ApplyHoliday.addActionListener(this);
            Holiday.add(ApplyHoliday);
        }else if(ID==1){
            //在教师选项，教师可以发布课修改信息
            ReleaseMessage =new JMenuItem("发布信息");
            ReleaseMessage.addActionListener(this);
            message.add(ReleaseMessage);
            ReviseMessage =new JMenuItem("修改信息");
            ReviseMessage.addActionListener(this);
            message.add(ReviseMessage);
            //在教师选项中，教师可以审批请假
            ApprovalHoliday=new JMenuItem("审批请假");
            ApprovalHoliday.addActionListener(this);
            Holiday.add(ApprovalHoliday);
        }
        //设置工具栏
        JMenuBar menuBar = new JMenuBar();
        //工具栏添加信息选项
        menuBar.add(message);
        //工具栏添加请假选项
        menuBar.add(Holiday);
        //把工具栏添加到界面
        this.setJMenuBar(menuBar);
        //设置总的界面的大小
        this.setBounds(100, 100, 900, 600);
        //关闭窗口程序停止
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置背景图片
        ImageIcon icon = new ImageIcon("src\\background.jpg");
        JLabel p = new JLabel(icon);
        p.setBounds(0, 0, 900, 600);
        this.add(p);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
            if(source==ShowMessage){

            }
            if(source==ApplyHoliday){

            }
        }
    }