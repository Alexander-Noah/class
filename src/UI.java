import javax.swing.*;

public class UI extends JFrame {

    int ID;

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
        JMenuItem message =new JMenuItem("信息");
        //请假的菜单选项
        JMenuItem Holiday=new JMenuItem("请假");
        //特有的功能
        if(ID==0){
            //在信息选项，学生只能查看信息
            JMenu ShowMessage =new JMenu("查看信息");
            message.add(ShowMessage);
            //在请假选项中，学生只能申请请假并查看状态
            JMenu ApplyHoliday =new JMenu("学生请假");
            Holiday.add(ApplyHoliday);
        }else if(ID==1){
            //在教师选项，教师可以发布课修改信息
            JMenu ReleaseMessage =new JMenu("发布信息");
            message.add(ReleaseMessage);
            JMenu ReviseMessage =new JMenu("修改信息");
            message.add(ReviseMessage);
            //在教师选项中，教师可以审批请假
            JMenu ApprovalHoliday=new JMenu("审批请假");
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
        this.setBounds(100, 100, 450, 300);
    }
}
