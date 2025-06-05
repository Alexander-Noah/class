import javax.swing.*;

public class UI extends JFrame {
    //接收id，0表示学生，1表示教师
    public UI(int ID){
        init();
        this.setVisible(true);
    }
    public void init(){
        this.setLayout(null);
        this.setAlwaysOnTop(true);
        JMenuItem message =new JMenuItem("信息");
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(message);
        this.setJMenuBar(menuBar);
        this.setBounds(100, 100, 450, 300);
    }
}
