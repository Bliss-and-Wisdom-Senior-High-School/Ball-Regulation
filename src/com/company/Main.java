package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;

public class Main extends JFrame {
    static int x=20;
    static int y=10;
    static int width=1500;
    static int height=900;

//    Calendar calendar = Calendar.getInstance();
    RandomAccessFile d = new RandomAccessFile("storage.txt","rw");

    FlowLayout flowLayout = new FlowLayout();
    FlowLayout flowLayout1 = new FlowLayout();

    JPanel pnlMenu = new JPanel();
    JPanel pnlNorth = new JPanel();
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
    JPanel pnlSouth = new JPanel();
    JPanel pnlSouth1 = new JPanel();
    JPanel pnlSouth2 = new JPanel();

    JLabel lblTitle = new JLabel();
    JLabel lblSearch = new JLabel("查看: ");
    JLabel lblTime = new JLabel();
    JLabel lblSenior = new JLabel("高中");
    JLabel lblJunior = new JLabel("国中");

    JButton btnHome = new JButton("主頁面");
    JButton btnHistory = new JButton("历史纪录");
    JButton btnClass = new JButton("班级");
    JButton btnScore = new JButton("点数");
    JButton btnTable = new JButton("时间表");
    JButton btnSetting = new JButton("设定");
    JButton btnBack = new JButton("返回");

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
//    JPanel pnlSenior=new JPanel();
//    JPanel pnlJunior=new JPanel();
    JPanel[][] pnlSeniorOrder= new JPanel[5][3];
    JPanel[][] PnlJuniorOrder=new JPanel[5][3];

//    JTable tabSenior=new JTable(seniorData, ballName);
    JScrollPane scrollPane1 = new JScrollPane(new JTable(seniorData, ballName));

//    JTable tabJunior=new JTable(juniorData, ballName);
    JScrollPane scrollPane2 = new JScrollPane(new JTable(juniorData, ballName));


    Main() throws FileNotFoundException {
        this.setSize(width,height);
        this.setLocation(x,y);
        this.setTitle("学务处借球登记　超ＯＰ");
        this.setLayout(new GridLayout());


        //主样板
        this.add(pnlMenu);
        GridLayout layMenu = new GridLayout(5,10);
        pnlMenu.setLayout(layMenu);
//        pnlMenu.setSize(1400,800);
//        pnlMenu.setBackground(Color.YELLOW);

        //上半
        pnlMenu.add(pnlNorth,BorderLayout.NORTH);
        pnlNorth.setLayout(new GridLayout());
//        lblTitle.setBackground(Color.BLACK);
        pnlNorth.add(lblTitle);
        lblTitle.setBackground(Color.GREEN);
        lblTitle.setFont(new Font("新细明體",Font.BOLD,30));
        lblTitle.setText("各班球场分配");//可以换
        pnlNorth.add(pnlNE);
        pnlNE.setLayout(new GridLayout(2,1));
        pnlNE.add(pnlNE1);
        pnlNE1.setLayout(new GridLayout());
        pnlNE1.add(btnHome);

        //时间
        lblTime.setText("民国X年X月X日 星期X");
        pnlDate.add(lblTime);
        pnlNE1.add(pnlDate);

        //功能表
        pnlFunction.setLayout(new FlowLayout());
        pnlFunction.add(lblSearch);
        pnlFunction.add(btnHistory);
        pnlFunction.add(btnClass);
        pnlFunction.add(btnScore);
        pnlFunction.add(btnTable);
        pnlNE.add(pnlFunction);

        btnHome.addActionListener(new action());
        btnClass.addActionListener(new action());
        btnHistory.addActionListener(new action());
        btnScore.addActionListener(new action());
        btnTable.addActionListener(new action());

        //内容
        pnlMenu.add(pnlCenter,BorderLayout.CENTER);
        pnlCenter.setLayout(new GridLayout());
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


        pnlCenter.add(pnlWeekend);
        pnlWeekend.setLayout(new GridLayout(2,1));
        pnlWeekend.add(pnlSenior);
        pnlWeekend.add(pnlJunior);
        pnlSenior.setLayout(new GridLayout());
        pnlSenior.add(scrollPane1);
        pnlJunior.setLayout(new GridLayout());
        pnlJunior.add(scrollPane2);


        //下半
        pnlMenu.add(pnlSouth,BorderLayout.SOUTH);
        pnlSouth.setLayout(new GridLayout());
        flowLayout.setAlignment(FlowLayout.LEFT);
        pnlSouth1.setLayout(flowLayout);
        pnlSouth1.add(btnSetting);
        pnlSouth.add(pnlSouth1);
        flowLayout.setAlignment(FlowLayout.RIGHT);
        pnlSouth2.setLayout(flowLayout);
        pnlSouth2.add(btnBack);
        pnlSouth.add(pnlSouth2);

    }

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Main frame = new Main();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void initialize() throws IOException {
        int num;
        num = d.readInt();

    }

    static class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
