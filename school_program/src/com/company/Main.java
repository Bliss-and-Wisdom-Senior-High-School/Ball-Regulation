package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Main extends JFrame {
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

    //位置?板
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
    //?容?板
    JPanel pnlInti = new JPanel();//初始?定（第一次使用）
    JPanel pnlSenior = new JPanel();
    JPanel pnlJunior = new JPanel();
    JPanel pnlSetting = new JPanel();
    JPanel pnlClass = new JPanel();
    JPanel pnlHistory = new JPanel();
    JPanel pnlTimeTable = new JPanel();

    //
    JLabel lblTitle = new JLabel();
    JLabel lblSearch = new JLabel("查看: ");
    JLabel lblTime = new JLabel();
    JLabel lblSenior = new JLabel("高中");
    JLabel lblJunior = new JLabel("國中");

    JButton btnHome = new JButton("主頁面");
    JButton btnHistory = new JButton("歷史紀錄");
    JButton btnClass = new JButton("班級");
    JButton btnScore = new JButton("點數");
    JButton btnTimeTable = new JButton("時間表");
    JButton btnSetting = new JButton("設定");
    JButton btnOK = new JButton("確定");
    JButton btnBack = new JButton("返回");
    JButton btnNext =new JButton("下一頁");
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

    String [] ballName={"班級","排球","桌球","羽球"};

//    String [][] juniorData={
//            {"國三忠","1","2","3"},
//            {"國三孝","1","2","3"},
//            {"國二忠","1","2","3"},
//            {"國二孝","1","2","3"},
//            {"國一忠","1","2","3"},
//            {"國一孝","1","2","3"}
//    };
//
//    String [][] seniorData={
//            {"高三忠","1","2","3"},
//            {"高三孝","1","2","3"},
//            {"高二忠","1","2","3"},
//            {"高二孝","1","2","3"},
//            {"高一忠","1","2","3"},
//            {"高一孝","1","2","3"},
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


    Main() throws FileNotFoundException {
        //建立系?
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //?窗
        this.setSize(width,height);
        this.setLocation(x,y);
        this.setTitle("學務處借球登?　超OP Fy(By) 兩本書&一只羊");
        BorderLayout thisLayout = new BorderLayout(50,60);
        this.setLayout(thisLayout);

        //主?板
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
        lblTitle.setFont(new Font("新?明體",Font.BOLD,50));
//        lblTitle.setText("各班球?分配");//可以?
        pnlNorth.add(pnlNE);
        pnlNE.setLayout(new GridLayout(2,1));
        pnlNE.add(pnlNE1);
        pnlNE1.setLayout(new GridLayout());

        //??
        lblTime.setText("民國"+school.getYear()+"年"+school.getMonth()+"月"+school.getDate()+"日 星期"+school.getDay());
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

        //?容
        
        pnlMenu.add(pnlCenter,BorderLayout.CENTER);
//        pnlCenter.setLayout(new GridLayout());
        pnlCenter.setLayout(card);

        //班?介面
        pnlCenter.add(pnlClass,"class");
        pnlClass.add(new LabelNotDone());

        //?史??介面
        pnlCenter.add(pnlHistory,"history");
        pnlHistory.add(new LabelNotDone());

        //點數介面
        pnlCenter.add(pnlScore,"score");
//        pnlScore.add(new LabelNotDone());

        ArrayList<String> cList = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<String> gList = new ArrayList<String>();
        ArrayList<String> bList = new ArrayList<String>();
        cList.add("班級");
        for (int i=0; i<school.getClassNum(); i++) {
            cList.add(school.getClass(i).getName());
        }
//        String[] s = cList.toArray(new String[cList.size()]);
//        for (String s1 : s)
//            System.out.println(s1);

        gList.add("優良??");
        for (int i=0; i<school.getClassNum(); i++) {
            gList.add(String.valueOf(school.getClass(i).getBadPoint()));
        }
        list.add(gList);

        bList.add("????");
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
        JTable table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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
//        JLabel lblAdd = new JLabel("增加優良點數");
//        JLabel lblSub = new JLabel("增加違規點數");
        pan[0].add(new JLabel("增加優良點數"));
        pan[1].add(new JLabel("增加違規點數"));
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

        //設定介面
        pnlCenter.add(pnlSetting,"setting");
        pnlSetting.setLayout(new GridLayout(2,1,70,10));
        JPanel pnlSetClass=new JPanel();
        JPanel pnlSetBall=new JPanel();
        pnlSetting.add(pnlSetClass);
        pnlSetClass.setLayout(new GridLayout(4,20+1,10,70));
        pnlSetting.add(pnlSetBall);
        pnlSetBall.setLayout(new GridLayout(5,6+1,20,10));

        classField = new JTextField[school.getClassNum()];
        gPointField = new JTextField[school.getClassNum()];
        bPointField = new JTextField[school.getClassNum()];
        banField = new JTextField[school.getClassNum()];

        String[]sBall={"球類名稱","球數量","球場數量","球拍數量","損毀球拍數"};
        JLabel classTitle=new JLabel("班級名稱");
        JLabel gPointTitle=new JLabel("優良點數");
        JLabel bPointTitle=new JLabel("違規點數");
        JLabel banTitle=new JLabel("是否禁球");
        JLabel ballNameTitle=new JLabel("球類名稱");
        JLabel courtTitle=new JLabel("球場數量");
        JLabel ballTitle=new JLabel("球數量");
        JLabel batTitle=new JLabel("球具數量");
        JLabel damagedTitle=new JLabel("已損球具數量");
        pnlSetClass.add(classTitle);
        for(int i=0;i<school.getClassNum();i++)
        {
            classField[i]=new JTextField(school.getClass(i).getClassName());
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
        //String[][]sSetBall={{"球類名稱","0","0","0","0"}};
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

        //??表界面
        pnlCenter.add(pnlTimeTable,"timeTable");
        pnlTimeTable.add(new LabelNotDone());

        //初始界面
//        pnlCenter.add(pnlInti,"Init");
//        pnlInti.add(new LabelNotDone());

//        pnlCenter.add(lblNotDone,"repaired");

        //周末借球填??序介面
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



        //周末分配?果介面
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

//        pnlSetting.setLayout(new GridLayout(1,5));
//        JLabel setText=new JLabel("變更");
//        JLabel setting=new JLabel("更改班級數為:");
//        String[] schoolList={"高中","國中"};
//        String[] gradeList={"一年級","二年級","三年級"};
//        String[] numList={"1","2","3","4"};
//        JList setList1=new JList(schoolList);
//        JList setList2=new JList(gradeList);
//        JList setList3=new JList(numList);
//        pnlInti.add(setText);
//        pnlInti.add(setList1);
//        pnlInti.add(setList2);
//        pnlInti.add(setting);
//        pnlInti.add(setList3);



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

        //按?
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
        card.show(pnlCenter,current);
        lblTitle.setText(getTitle(current));
        resetButton();

    }

    public static void main(String[] args) throws FileNotFoundException {
        // write your code here
        Main frame = new Main();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    void distribute() {

    }

//    int bl=20+4*4;
//    int cl=6+4*4;
//    int bNum;
//    int cNum;

    public void init() throws IOException {
        if(f.exists()) {//不是第一次登入
//            System.out.println(gson.toJson(school));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String s1 = "";
            String s2 = "";
            while ((s2 = reader.readLine()) != null) s1 += s2;
            reader.close();

            school = new Gson().fromJson(s1, School.class);
//            school = new Gson().fromJson(new FileReader(f), School.class);
        } else{//第一次登入
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
//        showStack();//用以??堆???
    }

    String getTitle(String str) {
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
        lblTitle.setText(getTitle(current));
        resetButton();
    }

    class action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = true;
            for (int i=0; i<school.getClassNum(); i++)
                if (e.getSource() == bb[0][i]) {
                    school.getClass(i).addBadPoint();
                    click("score");
                    System.out.println(school.getClass(i).getBadPoint());
                    b = false;
                    break;
                } else if(e.getSource() == bb[1][i]) {
                    school.getClass(i).addGoodPoint();
                    b = false;
                    click("score");
                    break;
                }

            if(b) {
                if (btnHome==e.getSource()) {
                    click("weekend");
                } else if(e.getSource()==btnOK){
                    if(Objects.equals(current, "weekend"))
                        click("weekendResult");
                    else if(Objects.equals(current, "setting")) {
                        //班??料更新
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setClassName(classField[i].getText());
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setGoodPoint(Integer.parseInt(gPointField[i].getText()));
                        for(int i=0; i< school.getClassNum(); i++)
                            school.getClass(i).setBadPoint(Integer.parseInt(bPointField[i].getText()));
//                        for(int i=0; i< school.getClassNum(); i++)
//                            school.getClass(i)(classField[i].getText());
                        //球??料更新
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
                    click("score");
                } else if(e.getSource()==btnSetting){
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
            this.setFont(new Font("新?明體",Font.BOLD,100));
            this.setText(" 此頁面尚未完成！ 請見諒");

        }
    }
}
