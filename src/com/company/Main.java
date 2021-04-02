package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Stack;

public class Main extends JFrame {
    static int x=20;
    static int y=10;
    static int width=1500;
    static int height=800;

//    Calendar calendar = Calendar.getInstance();
    RandomAccessFile d = new RandomAccessFile("storage.txt","rw");

    Stack<String> previous = new Stack<>();
    Stack<String> next = new Stack<>();

    School school;
    CardLayout card = new CardLayout();
    String current;

    JPanel pnlMenu = new JPanel();
    JPanel pnlNorth = new JPanel();
    JPanel pnlNW = new JPanel();
    JPanel pnlNE = new JPanel();
    JPanel pnlNE1 = new JPanel();
    JPanel pnlDate = new JPanel();
    JPanel pnlFunction = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlSenior = new JPanel();
    JPanel pnlSen31 = new JPanel();
    JPanel pnlSen21 = new JPanel();
    JPanel pnlSen22 = new JPanel();
    JPanel pnlSen11 = new JPanel();
    JPanel pnlSen12 = new JPanel();
    JPanel pnlJunior = new JPanel();
    JPanel pnlJun31 = new JPanel();
    JPanel pnlJun21 = new JPanel();
    JPanel pnlJun22 = new JPanel();
    JPanel pnlJun11 = new JPanel();
    JPanel pnlJun12 = new JPanel();
    JPanel pnlSetting = new JPanel();
    JPanel pnlClass = new JPanel();
    JPanel pnlHistory = new JPanel();
    JPanel pnlTimeTable = new JPanel();
    JPanel pnlScore = new JPanel();
    JPanel pnlSouth = new JPanel();
    JPanel pnlSouth1 = new JPanel();
    JPanel pnlSouth2 = new JPanel();

    JLabel lblTitle = new JLabel();
    JLabel lblSearch = new JLabel("查看: ");
    JLabel lblTime = new JLabel();
    JLabel lblSenior = new JLabel("高中");
    JLabel lblJunior = new JLabel("国中");

    JLabel lblNotDone = new JLabel("此页面尚未完成！ 请见谅");

    JButton btnHome = new JButton("主頁面");
    JButton btnHistory = new JButton("历史纪录");
    JButton btnClass = new JButton("班级");
    JButton btnScore = new JButton("点数");
    JButton btnTimeTable = new JButton("时间表");
    JButton btnSetting = new JButton("设定");
    JButton btnOK = new JButton("确定");
    JButton btnBack = new JButton("返回");
    JButton btnNext =new JButton("下一頁");

    String [] ballName={"班级","排球","桌球","羽球"};

    String [][] juniorData={
            {"國三忠","1","2","3"},
            {"國三孝","1","2","3"},
            {"國二忠","1","2","3"},
            {"國二孝","1","2","3"},
            {"國一忠","1","2","3"},
            {"國一孝","1","2","3"}
    };

    String [][] seniorData={
            {"高三忠","1","2","3"},
            {"高三孝","1","2","3"},
            {"高二忠","1","2","3"},
            {"高二孝","1","2","3"},
            {"高一忠","1","2","3"},
            {"高一孝","1","2","3"},
    };


    JPanel pnlWeekend=new JPanel();
    JPanel pnlWeekendResult = new JPanel();
//    JPanel pnlSenior=new JPanel();
//    JPanel pnlJunior=new JPanel();
    JPanel[][] pnlSeniorOrder= new JPanel[5][3];
    JPanel[][] PnlJuniorOrder=new JPanel[5][3];

    JTable tabSenior=new JTable(seniorData, ballName);
    JScrollPane scrollPane1 = new JScrollPane(tabSenior);

    JTable tabJunior=new JTable(juniorData, ballName);
    JScrollPane scrollPane2 = new JScrollPane(tabJunior);


    Main() throws FileNotFoundException {
        //建立系统
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        School school = new School();

        //视窗
        this.setSize(width,height);
        this.setLocation(x,y);
        this.setTitle("学务处借球登记　超ＯＰ by 兩本書&一只羊");
        BorderLayout thisLayout = new BorderLayout(50,60);
        this.setLayout(thisLayout);

        //主样板
        this.add(pnlMenu,BorderLayout.CENTER);
        pnlMenu.setSize(600,1000);
//        GridLayout layMenu = new GridLayout(5,10);
//        pnlMenu.setLayout(layMenu);
        pnlMenu.setLayout(new BorderLayout());
//        pnlMenu.setSize(1400,800);
//        pnlMenu.setBackground(Color.YELLOW);

        //上半
        pnlMenu.add(pnlNorth,BorderLayout.NORTH);
        pnlNorth.setAlignmentY(40);
        pnlNorth.setLayout(new GridLayout());
//        lblTitle.setBackground(Color.BLACK);
        pnlNorth.add(pnlNW);
        pnlNW.setLayout(new FlowLayout());
        pnlNW.add(lblTitle);
        lblTitle.setBackground(Color.GREEN);
        lblTitle.setFont(new Font("新细明體",Font.BOLD,50));
//        lblTitle.setText("各班球场分配");//可以换
        pnlNorth.add(pnlNE);
        pnlNE.setLayout(new GridLayout(2,1));
        pnlNE.add(pnlNE1);
        pnlNE1.setLayout(new GridLayout());

        //时间
        lblTime.setText("民国"+school.getYear()+"年"+school.getMonth()+"月"+school.getDate()+"日 星期"+school.getDay());
        pnlDate.add(lblTime);
        pnlNE1.add(pnlDate);

        //功能表
        pnlFunction.setLayout(new FlowLayout());
        pnlFunction.add(btnHome);
        pnlFunction.add(lblSearch);
        pnlFunction.add(btnHistory);
        pnlFunction.add(btnClass);
        pnlFunction.add(btnScore);
        pnlFunction.add(btnTimeTable);
        pnlNE.add(pnlFunction);

        //内容
        pnlMenu.add(pnlCenter,BorderLayout.CENTER);
//        pnlCenter.setLayout(new GridLayout());
        pnlCenter.setLayout(card);
//        pnlCenter.add(pnlSenior);
//        pnlSenior.setLayout(new GridLayout());
//        pnlSenior.add(lblSenior);
//        pnlSenior.add(pnlSen31);
//        pnlSenior.add(pnlSen21);
//        pnlSenior.add(pnlSen22);
//        pnlSenior.add(pnlSen11);
//        pnlSenior.add(pnlSen12);
//        pnlCenter.add(pnlJunior);
//        pnlJunior.setLayout(new GridLayout());
//        pnlJunior.add(lblJunior);
//        pnlJunior.add(pnlJun31);
//        pnlJunior.add(pnlJun21);
//        pnlJunior.add(pnlJun22);
//        pnlJunior.add(pnlJun11);
//        pnlJunior.add(pnlJun12);

        lblNotDone.setBackground(Color.RED);
        lblNotDone.setFont(new Font("新细明體",Font.BOLD,100));

        pnlCenter.add(pnlSetting,"setting");
        pnlSetting.add(new LabelNotDone());

        pnlCenter.add(pnlClass,"class");
        pnlClass.add(new LabelNotDone());

        pnlCenter.add(pnlHistory,"history");
        pnlHistory.add(new LabelNotDone());

        pnlCenter.add(pnlScore,"score");
        pnlScore.add(new LabelNotDone());

        pnlCenter.add(pnlTimeTable,"timeTable");
        pnlTimeTable.add(new LabelNotDone());

//        pnlCenter.add(lblNotDone,"repaired");

        //周末借球填写顺序
        pnlCenter.add(pnlWeekend,"weekend");
        pnlWeekend.setLayout(new GridLayout(2,1));
        pnlWeekend.add(pnlSenior);
        pnlWeekend.add(pnlJunior);
        pnlSenior.setLayout(new GridLayout());
        tabSenior.getTableHeader().setReorderingAllowed(false);
        tabSenior.setUpdateSelectionOnSort(false);
        pnlSenior.add(scrollPane1);
        pnlJunior.setLayout(new GridLayout());
//        tabJunior.setUpdateSelectionOnSort(false);
//        tabJunior.getTableHeader().setReorderingAllowed(false);
        pnlJunior.add(scrollPane2);

        //周末分配结果
        pnlCenter.add(pnlWeekendResult,"weekendResult");
        pnlWeekendResult.setLayout(new GridLayout(7,1));
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JPanel p5=new JPanel();
        JPanel p6=new JPanel();
        JLabel j7=new JLabel();
        p1.setLayout(new GridLayout(1,6));
        p2.setLayout(new GridLayout(1,6));
        p3.setLayout(new GridLayout(1,6));
        p4.setLayout(new GridLayout(1,6));
        p5.setLayout(new GridLayout(1,6));
        p6.setLayout(new GridLayout(1,6));
        pnlWeekendResult.add(p1);
        pnlWeekendResult.add(p2);
        pnlWeekendResult.add(p3);
        pnlWeekendResult.add(j7);
        pnlWeekendResult.add(p4);
        pnlWeekendResult.add(p5);
        pnlWeekendResult.add(p6);
        JLabel j11=new JLabel("國一忠");
        JLabel j12=new JLabel("國一孝");
        JLabel j21=new JLabel("國二忠");
        JLabel j22=new JLabel("國二孝");
        JLabel j31=new JLabel("國三忠");
        JLabel j32=new JLabel("國三孝");
        p1.add(j11);
        p1.add(j12);
        p1.add(j21);
        p1.add(j22);
        p1.add(j31);
        p1.add(j32);
        JLabel s11=new JLabel("高一忠");
        JLabel s12=new JLabel("高一孝");
        JLabel s21=new JLabel("高二忠");
        JLabel s22=new JLabel("高二孝");
        JLabel s31=new JLabel("高三忠");
        JLabel s32=new JLabel("高三孝");
        p4.add(s11);
        p4.add(s12);
        p4.add(s21);
        p4.add(s22);
        p4.add(s31);
        p4.add(s32);

        JPanel[][][] ball=new JPanel[2][6][2];
        for (int i =0; i<2; i++)
            for (int j =0; j<6; j++)
                for(int k =0; k<2;k++)
                    ball[i][j][k] = new JPanel();

        for(int i=0;i<6;i++)
        {
            p2.add(ball[0][i][0]);
            p3.add(ball[0][i][1]);
            p5.add(ball[1][i][0]);
            p6.add(ball[1][i][1]);
        }


        //下半
        pnlMenu.add(pnlSouth,BorderLayout.SOUTH);
        pnlSouth.setLayout(new GridLayout());
        FlowLayout flowLayout1 = new FlowLayout();
        flowLayout1.setAlignment(FlowLayout.LEFT);
        pnlSouth1.setLayout(flowLayout1);
        pnlSouth1.add(btnSetting);
        pnlSouth.add(pnlSouth1);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        pnlSouth2.setLayout(flowLayout);
        pnlSouth2.add(btnOK);
        pnlSouth2.add(btnBack);
        pnlSouth2.add(btnNext);
        pnlSouth.add(pnlSouth2);

        //按钮
        btnHome.addActionListener(new action());
        btnClass.addActionListener(new action());
        btnHistory.addActionListener(new action());
        btnScore.addActionListener(new action());
        btnTimeTable.addActionListener(new action());
        btnBack.addActionListener(new action());
        btnNext.addActionListener(new action());
        btnSetting.addActionListener(new action());
        btnOK.addActionListener(new action());

        //初始化
        current="weekend";
        card.show(pnlCenter,current);
        lblTitle.setText(getText(current));
        resetButton();
    }

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Main frame = new Main();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    int bl=20+4*4;
    int cl=6+4*4;
    int bNum;
    int cNum;

    public void init() throws IOException {
        bNum=d.readInt();
        for(int i=0;i<bNum;i++){
            byte[] bt=new byte[20];
            d.readFully(bt);
            int[] arr=new int[4];
            for(int j=0;j<4;j++)
                arr[j]=d.readInt();
            school.addBall(new Ball(new String(bt),arr[0],arr[1],arr[2],arr[3]));
        }
        cNum=d.readInt();
        for(int i=0;i<cNum;i++){
            byte[] bt=new byte[6];
            d.readFully(bt);
            int[] arr=new int[4];
            for(int j=0;j<4;j++)
                arr[j]=d.readInt();
            school.addBall(new Ball(new String(bt), arr[0], arr[1], arr[2], arr[3]));
        }

//        School school = new School();

    }


    public void resetButton () {
        btnNext.setEnabled(!next.empty());
        btnBack.setEnabled(!previous.empty());
        btnOK.setEnabled(current=="weekend");
//        showStack();
    }

    String getText(String str) {
        switch (str) {
            case "weekend" -> { return "星期日各班球場填寫志願"; }
            case "weekendResult" -> { return "星期日球場分配結果"; }
            case "class" -> { return "各班資料"; }
            case "history" -> { return "歷史紀錄"; }
            case "score" -> { return "各班優缺點數"; }
            case "setting" -> { return "設定"; }
            case "timeTable" -> { return "時間表"; }

            default -> throw new IllegalStateException("Unexpected value: " + str);
        }
    }

    void click(String str) {
        previous.push(current);
        current = str;
        next.clear();
        card.show(pnlCenter,current);
        lblTitle.setText(getText(current));
        resetButton();
    }

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (btnHome==e.getSource()) {
                click("weekend");
            } else if(e.getSource()==btnOK){
                click("weekendResult");
            } else if(e.getSource()==btnBack){
                next.push(current);
                current = previous.pop();
                card.show(pnlCenter,current);
                lblTitle.setText(getText(current));
                resetButton();
            } else if (e.getSource()==btnNext) {
                previous.push(current);
                current = next.pop();
                card.show(pnlCenter,current);
                lblTitle.setText(getText(current));
                resetButton();
            } else if(e.getSource()==btnClass){
                click("class");
            } else if(e.getSource()==btnHistory){
                click("history");
            } else if(e.getSource()==btnScore){
                click("score");
            } else if(e.getSource()==btnSetting){
                click("setting");
            } else if(e.getSource()==btnTimeTable){
                click("timeTable");
            } else {
                throw new IllegalStateException("Unexpected value: " + e.getSource());
            }

        }
    }

    void showStack() {
        System.out.println("next:");
        for (String s : next) System.out.println(s);
        System.out.println("previous:");
        for (String s : previous) System.out.println(s);
        System.out.println();
    }

    class LabelNotDone extends JLabel{
        LabelNotDone( ){
            this.setBackground(Color.RED);
            this.setFont(new Font("新细明體",Font.BOLD,100));

            this.setText(" 此页面尚未完成！ 请见谅");

        }
    }
}
