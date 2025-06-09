import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ClockIn extends JFrame{

    int ID;

    int Information;

    //打卡，ID表示学生还是老师（1 or 2），Information表示学生或老师的对应信息（每个老师学生都不一样）
    public ClockIn(int ID,int Information){
        this.ID=ID;
        this.Information=Information;

        //从数据库加载数据
        LoadFile();
        //初始化界面
        initFrame();
        //初始化组件
        initView();
        //窗口居中显示
        this.setLocationRelativeTo(null);
        //显示界面
        this.setVisible(true);

    }

    public void LoadFile(){
        //打卡信息1，2，教师学生通用变量，放最上面
        String s1=null;
        String s2=null;


        //读取学生的正在进行的打卡的信息
        if(ID==0){
            //学生用打卡信息（是否打卡）
            Boolean s11=null;
            Boolean s22=null;

            //查询指定学生的正在进行的打卡的信息，用Information
            //JAVA示范,假设从数据库里查询到了指定的信息
            //注意，限制一下，只查询最近的两个
            s1="信息课  9:00-10:00";//课程信息
            s11=false;//该学生是否已经打卡

            s2="电脑课  7:00-8:00";
            s22=true;

            //这个是记录获得的打卡信息有几个，用数据库SQL语句查询获得返回结果统计
            int count=2;

            //加油666
            //根据获取的结果数，调用相应的方法显示在界面上
            if(count==1){
                GetStudentUI(s1,s11);
            }else if(count==2){
                GetStudentUI(s1,s11,s2,s22);
            }else {//没有打卡信息，直接显示无
                JLabel l1=new JLabel("无");
                l1.setBounds(30,30,150,30);
                this.getContentPane().add(l1);
            }

        } else if (ID==1) {
            //教师用打卡信息记录
            Map<String,Boolean> Maps1=null;
            Map<String,Boolean> Maps2 = null;


            //查询相关老师的打卡信息
            //JAVA示范,假设从数据库里查询到了指定的信息
            //注意，限制一下，只查询最近的两个
            s1="信息课  9:00-10:00";//课程信息
            Maps1=new HashMap<>();//从服务器获取学生打卡信息，Map类型可以改，键：学生姓名，值：boolean，是or否（打卡）
            //示例，张三未打卡，李四打卡
            Maps1.put("张三",false);
            Maps1.put("李四",true);


            //这个是记录获得的打卡信息有几个，用数据库SQL语句查询获得返回结果统计
            int count=1;

            //根据获取的结果数，调用相应的方法显示在界面上
            if(count==1){
                GetTeacherUI(s1,Maps1);
            }else if(count==2){
                GetTeacherUI(s1,Maps2,s2,Maps2);
            }else {//没有打卡信息，直接显示无
                JLabel l1=new JLabel("无");
                l1.setBounds(30,30,150,30);
                this.getContentPane().add(l1);
            }
        }


    }

    //学生打卡界面，仅1条打卡信息
    public void GetStudentUI(String s1,Boolean s11){
        //显示打卡信息：xx课 xx:xx
        JLabel information=new JLabel(s1);
        information.setBounds(30,30,150,30);
        this.getContentPane().add(information);

        //如果打卡，则显示已打卡
        if(s11){
            //(CIYN:Clock In Yes ,已打卡)
            JLabel CIY=new JLabel("已经打卡");
            CIY.setBounds(200,30,150,30);
            this.getContentPane().add(CIY);
        }else{
            //(CIYN:Clock In No ,未打卡)
            JLabel CIN=new JLabel("未打卡");
            CIN.setBounds(200,30,150,30);
            this.getContentPane().add(CIN);

            //未打卡，添加打卡按钮
            JButton CI=new JButton("打卡");
            CI.setBounds(400,30,150,30);
            CI.addActionListener(e -> {
               //打卡的逻辑
               //写入数据库
               //JAVA本地模拟
                
            });
            this.getContentPane().add(CI);

        }

    }

    //学生打卡界面，2条打卡信息
    public void GetStudentUI(String s1,Boolean s11,String s2,Boolean s22){


    }

    //教师打卡主界面，仅1条打卡信息
    public void GetTeacherUI(String s1,Map<String,Boolean> Maps1){


    }
    //教师打卡主界面，2条打卡信息
    public void GetTeacherUI(String s1,Map<String,Boolean> Maps1,String s2,Map<String,Boolean> Maps2){



    }

    public void initFrame(){
        this.setBounds(100,100,500,500);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("打卡");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void initView(){
        //如果是学生
        if(ID==0){
            JLabel Txt = new JLabel("正在进行的打卡:");
            Txt.setBounds(50,50,150,30);
            this.getContentPane().add(Txt);
        }else if(ID==1){
            JLabel Txt = new JLabel("打卡信息查看");
            Txt.setBounds(200,20,150,30);
            this.getContentPane().add(Txt);
        }
    }

}
