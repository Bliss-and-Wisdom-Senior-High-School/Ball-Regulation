package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Main extends Frame {
    static int x=20;
    static int y=10;
    static int width=1500;
    static int height=800;

    File f = new File("storage.txt");

    Stack<String> previous = new Stack<>();
    Stack<String> next = new Stack<>();

    School school;
    CardLayout card = new CardLayout();
    String current = "weekend";

    //��m?�O
    JPanel pnlMenu = new JPanel();
    JPanel pnlNorth = new JPanel();
    JPanel pnlNW = new JPanel();
    JPanel pnlNE = new JPanel();
    JPanel pnlNE1 = new JPanel();
    JPanel pnlDate = new JPanel();
    JPanel pnlFunction = new JPanel();
    JPanel pnlCenter = new JPanel();
    JPanel pnlScore = new JPanel();
    JPanel pnlSouth = new JPanel();
    JPanel pnlSouth1 = new JPanel();
    JPanel pnlSouth2 = new JPanel();
    //    JPanel pnlSen31 = new JPanel();
    //    JPanel pnlSen21 = new JPanel();
    //    JPanel pnlSen22 = new JPanel();
    //    JPanel pnlSen11 = new JPanel();
    //    JPanel pnlSen12 = new JPanel();
    //    JPanel pnlJun31 = new JPanel();
    //    JPanel pnlJun21 = new JPanel();
    //    JPanel pnlJun22 = new JPanel();
    //    JPanel pnlJun11 = new JPanel();
    //    JPanel pnlJun12 = new JPanel();
    //?�e?�O
    JPanel pnlInti = new JPanel();//��l?�w�]�Ĥ@���ϥΡ^
    JPanel pnlSenior = new JPanel();
    JPanel pnlJunior = new JPanel();
    JPanel pnlSetting = new JPanel();
    JPanel pnlClass = new JPanel();
    JPanel pnlHistory = new JPanel();
    JPanel pnlTimeTable = new JPanel();

    //
    JLabel lblTitle = new JLabel();
    JLabel lblSearch = new JLabel("�d��: ");
    JLabel lblTime = new JLabel();
    JLabel lblSenior = new JLabel("����");
    JLabel lblJunior = new JLabel("�ꤤ");

    JButton btnHome = new JButton("�D����");
    JButton btnHistory = new JButton("���v����");
    JButton btnClass = new JButton("�Z��");
    JButton btnScore = new JButton("�I��");
    JButton btnTimeTable = new JButton("�ɶ���");
    JButton btnSetting = new JButton("�]�w");
    JButton btnOK = new JButton("�T�w");
    JButton btnBack = new JButton("��^");
    JButton btnNext =new JButton("�U�@��");
    JButton[][] bb;

    JTextField[] classField;
    JTextField[] gPointField;
    JTextField[] bPointField;
    JTextField[] banField;

    JTextField[] ballNameField;
    JTextField[] courtField;
    JTextField[] ballField;
    JTextField[] batField;
    JTextField[] damagedField;

    String [] ballName={"�Z��","�Ʋy","��y","�вy"};

//    String [][] juniorData={
//            {"��T��","1","2","3"},
//            {"��T��","1","2","3"},
//            {"��G��","1","2","3"},
//            {"��G��","1","2","3"},
//            {"��@��","1","2","3"},
//            {"��@��","1","2","3"}
//    };
//
//    String [][] seniorData={
//            {"���T��","1","2","3"},
//            {"���T��","1","2","3"},
//            {"���G��","1","2","3"},
//            {"���G��","1","2","3"},
//            {"���@��","1","2","3"},
//            {"���@��","1","2","3"},
//    };


    JPanel pnlWeekend=new JPanel();
    JPanel pnlWeekendResult = new JPanel();
    //    JPanel pnlSenior=new JPanel();
//    JPanel pnlJunior=new JPanel();
//    JPanel[][] pnlSeniorOrder= new JPanel[5][3];
//    JPanel[][] PnlJuniorOrder=new JPanel[5][3];

    JTable tabSenior;
    JScrollPane scrollPane1;

    JTable tabJunior;
    JScrollPane scrollPane2;

    JTable table;

    Main() throws FileNotFoundException {
        //�إߨt?
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //?��
        this.setSize(width,height);
        this.setLocation(x,y);
        this.setTitle("�ǰȳB�ɲy�n?�@�WOP Fy(By) �⥻��&�@�u��");
        BorderLayout thisLayout = new BorderLayout(50,60);
        this.setLayout(thisLayout);

        //�D?�O
        this.add(pnlMenu,BorderLayout.CENTER);
        pnlMenu.setSize(600,1000);
//        GridLayout layMenu = new GridLayout(5,10);
//        pnlMenu.setLayout(layMenu);
        pnlMenu.setLayout(new BorderLayout());
//        pnlMenu.setSize(1400,800);
//        pnlMenu.setBackground(Color.YELLOW);

        //�W�b
        pnlMenu.add(pnlNorth,BorderLayout.NORTH);
        pnlNorth.setAlignmentY(40);
        pnlNorth.setLayout(new GridLayout());
//        lblTitle.setBackground(Color.BLACK);
        pnlNorth.add(pnlNW);
        pnlNW.setLayout(new FlowLayout());
        pnlNW.add(lblTitle);
        lblTitle.setBackground(Color.GREEN);
        lblTitle.setFont(new Font("�s?����",Font.BOLD,50));
//        lblTitle.setText("�U�Z�y?���t");//�i�H?
        pnlNorth.add(pnlNE);
        pnlNE.setLayout(new GridLayout(2,1));
        pnlNE.add(pnlNE1);
        pnlNE1.setLayout(new GridLayout());

        //??
        lblTime.setText("����"+school.getYear()+"�~"+school.getMonth()+"��"+school.getDate()+"�� �P��"+school.getDay());
        pnlDate.add(lblTime);
        pnlNE1.add(pnlDate);

        //�\���
        pnlFunction.setLayout(new FlowLayout());
        pnlFunction.add(btnHome);
        pnlFunction.add(lblSearch);
        pnlFunction.add(btnHistory);
        pnlFunction.add(btnClass);
        pnlFunction.add(btnScore);
        pnlFunction.add(btnTimeTable);
        pnlNE.add(pnlFunction);

        //���e
        
        pnlMenu.add(pnlCenter,BorderLayout.CENTER);
//        pnlCenter.setLayout(new GridLayout());
        pnlCenter.setLayout(card);

        //�Z�Ť���
        pnlCenter.add(pnlClass,"class");
        pnlClass.add(new LabelNotDone());

        //���v��������
        pnlCenter.add(pnlHistory,"history");
        pnlHistory.add(new LabelNotDone());

        //�I�Ƥ���
        pnlCenter.add(pnlScore,"score");
//        pnlScore.add(new LabelNotDone());

        ArrayList<String> cList = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<String> gList = new ArrayList<String>();
        ArrayList<String> bList = new ArrayList<String>();
        cList.add("�Z��");
        for (int i=0; i<school.getClassNum(); i++) {
            cList.add(school.getClass(i).getName());
        }
//        String[] s = cList.toArray(new String[cList.size()]);
//        for (String s1 : s)
//            System.out.println(s1);

        gList.add("�u�}�I��");
        for (int i=0; i<school.getClassNum(); i++) {
            gList.add(String.valueOf(school.getClass(i).getGoodPoint()));
        }
        list.add(gList);

        bList.add("�H�W�I��");
        for (int i=0; i<school.getClassNum(); i++) {
            bList.add(String.valueOf(school.getClass(i).getBadPoint()));
        }
        list.add(bList);

        String[][] ss = new String[list.size()][];
        for (int i=0; i<list.size(); i++) {
            ss[i] = list.get(i).toArray(new String[list.get(i).size()]);
        }

        JPanel[] pac=new JPanel[2];
        DefaultTableModel tableModel = new DefaultTableModel(ss, cList.toArray(new String[cList.size()]));
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowMargin(10);
        table.setRowHeight(50);
        table.setFont(new Font("�s�ө���",Font.BOLD,15));

        JScrollPane scrollPane=new JScrollPane(table);
        JPanel[] pan=new JPanel[2];
        bb = new JButton[2][school.getClassNum()];

        pnlScore.setLayout(new GridLayout(2,1,0,10));
        // JLabel[] pnlFst=new JLabel[12];
        for(int i=0;i<2;i++)
        {
            pac[i]=new JPanel();
            pnlScore.add(pac[i]);
            pac[i].setLayout(new GridLayout(i+1,school.getClassNum()+1,10,0));
            //pnlFst[i]=new JLabel("       "+juniorData[i][0]);
            // pnlFst[i+6]=new JLabel("       "+seniorData[i][0]);
            pan[i]=new JPanel();
            pan[i].setLayout(new GridLayout(0,school.getClassNum()+1,0,10));
        }
        pac[0].add(scrollPane);
        pac[1].add(pan[0]);
        pac[1].add(pan[1]);
//        JLabel lblAdd = new JLabel("�W�[�u�}�I��");
//        JLabel lblSub = new JLabel("�W�[�H�W�I��");
        pan[0].add(new JLabel("�W�[�u�}�I��"));
        pan[1].add(new JLabel("�W�[�H�W�I��"));
        for(int i=0;i< school.getClassNum();i++)
        {
            // pac[0].add(pnlFst[i]);
            bb[0][i]=new JButton("+1");
            bb[1][i]=new JButton("-1");
            for (int j=0; j<2; j++ ) {
                int finalI = i;
                int finalJ = j;
                bb[j][i].addActionListener( new action());
            }
            pan[0].add(bb[0][i]);
            pan[1].add(bb[1][i]);
        }

        //�]�w����
        pnlCenter.add(pnlSetting,"setting");
        pnlSetting.setLayout(new GridLayout(2,1,70,10));
        JPanel pnlSetClass=new JPanel();
        JPanel pnlSetBall=new JPanel();
        pnlSetting.add(pnlSetClass);
        pnlSetClass.setLayout(new GridLayout(4,school.getClassNum()+1,10,70));
        pnlSetting.add(pnlSetBall);
        pnlSetBall.setLayout(new GridLayout(5, school.getBallKinds()+1,20,10));

        classField = new JTextField[school.getClassNum()];
        gPointField = new JTextField[school.getClassNum()];
        bPointField = new JTextField[school.getClassNum()];
        banField = new JTextField[school.getClassNum()];

        String[]sBall={"�y���W��","�y�ƶq","�y���ƶq","�y��ƶq","�l���y���"};
        JLabel classTitle=new JLabel("�Z�ŦW��");
        JLabel gPointTitle=new JLabel("�u�}�I��");
        JLabel bPointTitle=new JLabel("�H�W�I��");
        JLabel banTitle=new JLabel("�O�_�T�y");
        JLabel ballNameTitle=new JLabel("�y���W��");
        JLabel courtTitle=new JLabel("�y���ƶq");
        JLabel ballTitle=new JLabel("�y�ƶq");
        JLabel batTitle=new JLabel("�y��ƶq");
        JLabel damagedTitle=new JLabel("�w�l�y��ƶq");
        pnlSetClass.add(classTitle);
        for(int i=0;i<school.getClassNum();i++)
        {
            classField[i]=new JTextField(school.getClass(i).getName());
            pnlSetClass.add(classField[i]);
        }
        pnlSetClass.add(gPointTitle);
        for(int i=0;i<school.getClassNum();i++)
        {
            gPointField[i]=new JTextField(String.valueOf(school.getClass(i).getGoodPoint()));
            pnlSetClass.add(gPointField[i]);
        }
        pnlSetClass.add(bPointTitle);
        for(int i=0;i<school.getClassNum();i++)
        {
            bPointField[i]=new JTextField(String.valueOf(school.getClass(i).getBadPoint()));
            pnlSetClass.add(bPointField[i]);
        }
        pnlSetClass.add(banTitle);
        for(int i=0;i<school.getClassNum();i++)
        {
            banField[i]=new JTextField(school.getClass(i).getBanned());
            pnlSetClass.add(banField[i]);
        }
        //String[][]sSetBall={{"�y���W��","0","0","0","0"}};
        ballNameField = new JTextField[school.getBallKinds()];
        courtField = new JTextField[school.getBallKinds()];
        ballField = new JTextField[school.getBallKinds()];
        batField = new JTextField[school.getBallKinds()];
        damagedField = new JTextField[school.getBallKinds()];
        pnlSetBall.add(ballNameTitle);
        for(int i=0; i<school.getBallKinds(); i++)
        {
            ballNameField[i]=new JTextField(school.getBall(i).getName());
            pnlSetBall.add(ballNameField[i]);
        }
        pnlSetBall.add(courtTitle);
        for(int i=0; i<school.getBallKinds(); i++)
        {
            courtField[i]=new JTextField(String.valueOf(school.getBall(i).getCourtNum()));
            pnlSetBall.add(courtField[i]);
        }
        pnlSetBall.add(ballTitle);
        for(int i=0; i<school.getBallKinds(); i++)
        {
            ballField[i]=new JTextField(String.valueOf(school.getBall(i).getBallNum()));
            pnlSetBall.add(ballField[i]);
        }
        pnlSetBall.add(batTitle);
        for(int i=0;i<school.getBallKinds();i++)
        {
            batField[i]=new JTextField(String.valueOf(school.getBall(i).getBatNum()));
            pnlSetBall.add(batField[i]);
        }
        pnlSetBall.add(damagedTitle);
        for(int i=0;i<school.getBallKinds();i++)
        {
            damagedField[i]=new JTextField(String.valueOf(school.getBall(i).getBallDamaged()));
            pnlSetBall.add(damagedField[i]);
        }
        //JTable tableClass=new JTable(sSetClass,sClass);
        //JTable tableBall=new JTable(sSetBall,sBall);
        //pnlSetBall.add(tableBall);
        //  pnlSetClass.add(tableClass);

        //�ɶ���ɭ�
        pnlCenter.add(pnlTimeTable,"timeTable");
        pnlTimeTable.add(new LabelNotDone());

        //��l�ɭ� (�w�}�J?�w�ɭ�)
//        pnlCenter.add(pnlInti,"Init");
//        pnlInti.add(new LabelNotDone());

//        pnlCenter.add(lblNotDone,"repaired");

        //�P���ɲy��g���Ǥ���
        pnlCenter.add(pnlWeekend,"weekend");
        pnlWeekend.setLayout(new GridLayout(2,1));
        pnlWeekend.add(pnlSenior);
        pnlWeekend.add(pnlJunior);

        String[][] sSenior = new String[school.getSenior().length][4];
        for (int i=0; i<school.getSenior().length; i++) {
            sSenior[i][0] = school.getSenior()[i].getName();
            for (int j=1; j<=3; j++)
                sSenior[i][j] = String.valueOf(j);
        }
        tabSenior = new JTable( sSenior, ballName);
        scrollPane1 = new JScrollPane(tabSenior);
        pnlSenior.add(scrollPane1);

        String[][] sJunior = new String[school.getJunior().length][4];
        for (int i=0; i<school.getJunior().length; i++) {
            sJunior[i][0] = school.getJunior()[i].getName();
            for (int j=1; j<=3; j++)
                sJunior[i][j] = String.valueOf(j);
        }
        tabJunior = new JTable( sJunior, ballName);
        scrollPane2 = new JScrollPane(tabJunior);
        pnlJunior.add(scrollPane2);

        pnlSenior.setLayout(new GridLayout());
        tabSenior.getTableHeader().setReorderingAllowed(false);
        tabSenior.setUpdateSelectionOnSort(false);
        pnlJunior.setLayout(new GridLayout());
//        tabJunior.setUpdateSelectionOnSort(false);
//        tabJunior.getTableHeader().setReorderingAllowed(false);



        //�P�����t���G����
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
        JLabel j11=new JLabel("��@��");
        JLabel j12=new JLabel("��@��");
        JLabel j21=new JLabel("��G��");
        JLabel j22=new JLabel("��G��");
        JLabel j31=new JLabel("��T��");
        JLabel j32=new JLabel("��T��");
        p1.add(j11);
        p1.add(j12);
        p1.add(j21);
        p1.add(j22);
        p1.add(j31);
        p1.add(j32);
        JLabel s11=new JLabel("���@��");
        JLabel s12=new JLabel("���@��");
        JLabel s21=new JLabel("���G��");
        JLabel s22=new JLabel("���G��");
        JLabel s31=new JLabel("���T��");
        JLabel s32=new JLabel("���T��");
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

//        pnlSetting.setLayout(new GridLayout(1,5));
//        JLabel setText=new JLabel("�ܧ�");
//        JLabel setting=new JLabel("���Z�żƬ�:");
//        String[] schoolList={"����","�ꤤ"};
//        String[] gradeList={"�@�~��","�G�~��","�T�~��"};
//        String[] numList={"1","2","3","4"};
//        JList setList1=new JList(schoolList);
//        JList setList2=new JList(gradeList);
//        JList setList3=new JList(numList);
//        pnlInti.add(setText);
//        pnlInti.add(setList1);
//        pnlInti.add(setList2);
//        pnlInti.add(setting);
//        pnlInti.add(setList3);



        //�U�b
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

        //����
        btnHome.addActionListener(new action());
        btnClass.addActionListener(new action());
        btnHistory.addActionListener(new action());
        btnScore.addActionListener(new action());
        btnTimeTable.addActionListener(new action());
        btnBack.addActionListener(new action());
        btnNext.addActionListener(new action());
        btnSetting.addActionListener(new action());
        btnOK.addActionListener(new action());

        //��l��
        card.show(pnlCenter,current);
        lblTitle.setText(getTitle(current));
        resetButton();

    }

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Main frame = new Main();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    frame.saveFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    void distribute() {

    }

    void resetSetting() {
        //�Z��
        for (int i=0; i<school.getClassNum(); i++)
            classField[i].setText(school.getClass(i).getName());
        for(int i=0; i<school.getClassNum(); i++)
            gPointField[i].setText(String.valueOf(school.getClass(i).getGoodPoint()));
        for (int i=0; i< school.getClassNum(); i++)
            bPointField[i].setText(String.valueOf(school.getClass(i).getBadPoint()));
//        for (int i=0; i<school.getClassNum(); i++)
//            �T�y
        //�y��
        for (int i=0; i<school.getBallKinds(); i++)
            ballNameField[i].setText(String.valueOf(school.getBall(i).getName()));
        for (int i=0; i<school.getBallKinds(); i++)
            courtField[i].setText(String.valueOf(school.getBall(i).getCourtNum()));
        for (int i=0; i<school.getBallKinds(); i++)
            ballField[i].setText(String.valueOf(school.getBall(i).getBallNum()));
        for (int i=0; i<school.getBallKinds(); i++)
            batField[i].setText(String.valueOf(school.getBall(i).getBatNum()));
        for (int i=0; i<school.getBallKinds(); i++)
            damagedField[i].setText(String.valueOf(school.getBall(i).getBallDamaged()));
    }

    void resetScore() {
        for (int i=0; i<school.getClassNum(); i++)
            table.setValueAt(String.valueOf(school.getClass(i).getGoodPoint()),0,i+1);
        for (int i=0; i<school.getClassNum(); i++)
            table.setValueAt(String.valueOf(school.getClass(i).getBadPoint()),1,i+1);
    }

    public void init() throws IOException {
        if(f.exists()) {//���O�Ĥ@���n�J
//            System.out.println(gson.toJson(school));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String s1 = "";
            String s2 = "";
            while ((s2 = reader.readLine()) != null) s1 += s2;
            reader.close();

            school = new Gson().fromJson(s1, School.class);
//            school = new Gson().fromJson(new FileReader(f), School.class);
        } else{//�Ĥ@���n�J
//            new Gson().toJson(new School(), new FileWriter(f));
            school=new School();
            saveFile();
            current = "setting";
        }

    }

    public void saveFile() throws IOException {
        String s = new Gson().toJson(school);
        OutputStreamWriter output = new OutputStreamWriter(new FileOutputStream(f));
        output.write(s);
        output.close();
    }


    public void resetButton () {
        btnNext.setEnabled(!next.empty());
        btnBack.setEnabled(!previous.empty());
        btnOK.setEnabled(Objects.equals(current, "weekend") || Objects.equals(current, "setting"));
//        showStack();//�ΥH��ܰ�n���G
    }

    String getTitle(String str) {
        switch (str) {
            case "weekend" -> { return "�P����U�Z�y����g���@"; }
            case "weekendResult" -> { return "�P����y�����t���G"; }
            case "class" -> { return "�U�Z���"; }
            case "history" -> { return "���v����"; }
            case "score" -> { return "�U�Z�u���I��"; }
            case "setting" -> { return "�]�w"; }
            case "timeTable" -> { return "�ɶ���"; }

            default -> throw new IllegalStateException("Unexpected value: " + str);
        }
    }

    void click(String str) {
        previous.push(current);
        current = str;
        next.clear();
        card.show(pnlCenter,current);
        lblTitle.setText(getTitle(current));
        resetButton();
    }

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = true;
            for (int i=0; i<school.getClassNum(); i++)
                if (e.getSource() == bb[0][i]) {
                    school.getClass(i).addGoodPoint();
                    table.setValueAt(school.getClass(i).getGoodPoint(),0, i+1);
                    click("score");
//                    System.out.println(school.getClass(i).getGoodPoint());
                    b = false;
                    break;
                } else if(e.getSource() == bb[1][i]) {
                    school.getClass(i).addBadPoint();
                    table.setValueAt(school.getClass(i).getBadPoint(),1, i+1);
                    click("score");
                    b = false;
                    break;
                }

            if(b) {
                if (btnHome==e.getSource()) {
                    click("weekend");
                } else if(e.getSource()==btnOK){
                    if(Objects.equals(current, "weekend"))
                        click("weekendResult");
                    else if(current == "setting") {
                        //�Z�Ÿ�Ƨ�s
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setClassName(classField[i].getText());
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setGoodPoint(Integer.parseInt(gPointField[i].getText()));
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setBadPoint(Integer.parseInt(bPointField[i].getText()));
//                        for(int i=0; i< school.getClassNum(); i++)
//                            school.getClass(i)(classField[i].getText());
                        //�y����Ƨ�s
                        int num = school.getBallKinds();
                        school.clearBall();
                        for (int i=0; i<num; i++) {
                            school.addBall(new Ball(
                                    ballNameField[i].getText(),
                                    Integer.parseInt(courtField[i].getText()),
                                    Integer.parseInt(ballField[i].getText()),
                                    Integer.parseInt(batField[i].getText()),
                                    Integer.parseInt(damagedField[i].getText())));
                        }
                        try {
                            saveFile();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                } else if(e.getSource()==btnBack){
                    next.push(current);
                    current = previous.pop();
                    card.show(pnlCenter,current);
                    lblTitle.setText(getTitle(current));
                    resetButton();
                } else if (e.getSource()==btnNext) {
                    previous.push(current);
                    current = next.pop();
                    card.show(pnlCenter,current);
                    lblTitle.setText(getTitle(current));
                    resetButton();
                } else if(e.getSource()==btnClass){
                    click("class");
                } else if(e.getSource()==btnHistory){
                    click("history");
                } else if(e.getSource()==btnScore){
                    resetScore();
                    click("score");
                } else if(e.getSource()==btnSetting){
                    resetSetting();
                    click("setting");
                } else if(e.getSource()==btnTimeTable){
                    click("timeTable");
//            } else if() {
//
                } else {
                    throw new IllegalStateException("Unexpected value: " + e.getSource());
                }
            }

        }
    }

    void showStack() { //�˵��ΡA��ܭ�����n
        System.out.println("next:");
        for (String s : next) System.out.println(s);
        System.out.println("previous:");
        for (String s : previous) System.out.println(s);
        System.out.println();
    }

    static class LabelNotDone extends JLabel{
        LabelNotDone( ){
            this.setBackground(Color.RED);
            this.setFont(new Font("�s�ө���",Font.BOLD,100));
            this.setText(" �������|�������I �Ш���");

        }
    }
}
