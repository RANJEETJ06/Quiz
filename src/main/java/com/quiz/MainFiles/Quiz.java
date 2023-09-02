package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Quiz extends JFrame implements ActionListener {
    public String[][] Questions =new String[10][5];
    public String[][] Answers=new String[10][2];
    public static String[][] userAnswers=new String[10][1];
    public static boolean life=true;
    JButton next,lifeLine,submit;
    JLabel qNo,question;
    JRadioButton option1,option2,option3,option4;
    ButtonGroup optGroup;
    public static int given_Ans=0;
    public static int timer=15;
    public static int count=0,score=0;
    public static String S;

    public static void main(String[] args) {
        new Quiz("Lela");
    }
    public Quiz(String s){
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        S=s;
        //all questions
        Questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        Questions[0][1] = "JVM";
        Questions[0][2] = "JDB";
        Questions[0][3] = "JDK";
        Questions[0][4] = "JRE";

        Questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        Questions[1][1] = "int";
        Questions[1][2] = "Object";
        Questions[1][3] = "long";
        Questions[1][4] = "void";

        Questions[2][0] = "Which package contains the Random class?";
        Questions[2][1] = "java.util package";
        Questions[2][2] = "java.lang package";
        Questions[2][3] = "java.awt package";
        Questions[2][4] = "java.io package";

        Questions[3][0] = "An interface with no fields or methods is known as?";
        Questions[3][1] = "Runnable Interface";
        Questions[3][2] = "Abstract Interface";
        Questions[3][3] = "Marker Interface";
        Questions[3][4] = "CharSequence Interface";

        Questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        Questions[4][1] = "Stack";
        Questions[4][2] = "String memory";
        Questions[4][3] = "Random storage space";
        Questions[4][4] = "Heap memory";

        Questions[5][0] = "Which of the following is a marker interface?";
        Questions[5][1] = "Runnable interface";
        Questions[5][2] = "Remote interface";
        Questions[5][3] = "Readable interface";
        Questions[5][4] = "Result interface";

        Questions[6][0] = "Which keyword is used for accessing the features of a package?";
        Questions[6][1] = "import";
        Questions[6][2] = "package";
        Questions[6][3] = "extends";
        Questions[6][4] = "export";

        Questions[7][0] = "In java, jar stands for?";
        Questions[7][1] = "Java Archive Runner";
        Questions[7][2] = "Java Archive";
        Questions[7][3] = "Java Application Resource";
        Questions[7][4] = "Java Application Runner";

        Questions[8][0] = "Which of the following is a mutable class in java?";
        Questions[8][1] = "java.lang.StringBuilder";
        Questions[8][2] = "java.lang.Short";
        Questions[8][3] = "java.lang.Byte";
        Questions[8][4] = "java.lang.String";

        Questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        Questions[9][1] = "Bytecode is executed by JVM";
        Questions[9][2] = "The applet makes the Java code secure and portable";
        Questions[9][3] = "Use of exception handling";
        Questions[9][4] = "Dynamic binding between objects";

        //all answers
        Answers[0][1] = "JDB";
        Answers[1][1] = "int";
        Answers[2][1] = "java.util package";
        Answers[3][1] = "Marker Interface";
        Answers[4][1] = "Heap memory";
        Answers[5][1] = "Remote interface";
        Answers[6][1] = "import";
        Answers[7][1] = "Java Archive";
        Answers[8][1] = "java.lang.StringBuilder";
        Answers[9][1] = "Bytecode is executed by JVM";

        setBounds(130,0,1000,670);
        setVisible(true);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("com/quiz/icons/quiz .jpg"));
        JLabel image=new JLabel(i);
        image.setBounds(0,0,1000,378);
        add(image);

        qNo=new JLabel();
        qNo.setBounds(100,400,30,20);
        qNo.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(qNo);

        question=new JLabel();
        question.setBounds(130,400,800,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(question);

        option1=new JRadioButton();
        option1.setBounds(120,430,500,30);
        option1.setBackground(Color.CYAN);
        option1.setFont(new Font("Dialog",Font.PLAIN,18));
        add(option1);
        option2=new JRadioButton();
        option2.setBounds(120,470,500,30);
        option2.setBackground(Color.CYAN);
        option2.setFont(new Font("Dialog",Font.PLAIN,18));
        add(option2);
        option3=new JRadioButton();
        option3.setBounds(120,510,500,30);
        option3.setBackground(Color.CYAN);
        option3.setFont(new Font("Dialog",Font.PLAIN,18));
        add(option3);
        option4=new JRadioButton();
        option4.setBounds(120,550,500,30);
        option4.setBackground(Color.CYAN);
        option4.setFont(new Font("Dialog",Font.PLAIN,18));
        add(option4);
        optGroup=new ButtonGroup();
        optGroup.add(option1);
        optGroup.add(option2);
        optGroup.add(option3);
        optGroup.add(option4);

        next=new JButton("Next");
        next.setBounds(750,440,120,35);
        next.setFont(new Font("",Font.PLAIN,20));
        next.setBackground(new Color(44, 169, 245));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        lifeLine=new JButton("50-50");
        lifeLine.setBounds(750,490,120,35);
        lifeLine.setFont(new Font("",Font.PLAIN,20));
        lifeLine.setBackground(new Color(44, 169, 245));
        lifeLine.setForeground(Color.white);
        lifeLine.addActionListener(this);
        add(lifeLine);

        submit=new JButton("Submit");
        submit.setBounds(750,540,120,35);
        submit.setFont(new Font("",Font.PLAIN,20));
        submit.setBackground(new Color(44, 169, 245));
        submit.setForeground(Color.white);
        submit.setVisible(false);
        submit.addActionListener(this);
        add(submit);
        start(count);
    }
    public void paint(Graphics g){
        super.paint(g);
        String time=" Time Left "+timer+" seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Times New Roman",Font.BOLD,20));
        if(timer>0){
            g.drawString(time,720,425);
        }else {
            g.drawString("TimesUp!",720,425);
        }
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(given_Ans==1){
            given_Ans=0;
            timer=15;
        } else if (timer<0) {
            timer=15;
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            lifeLine.setVisible(life);

            if(count==8){
                next.setVisible(false);
                submit.setVisible(true);
            }
            if(count==9){//10th Question submit case
                if (optGroup.getSelection() == null) {
                    userAnswers[count][0] = "";
                } else {
                    userAnswers[count][0] = optGroup.getSelection().getActionCommand();
                }
                for(int i=0;i<userAnswers.length;i++){
                    System.out.println(score);
                    if(userAnswers[i][0].equals(Answers[i][1])){
                        score+=10;
                    }else {
                        score-=-1;
                    }
                }
                setVisible(false);
                if(!life){
                    new Score(S,score-20);
                }else{
                    new Score(S,score);
                }
                count=0;
                score=0;
                life=true;
            }else {
                if (optGroup.getSelection() == null) {
                    userAnswers[count][0] = "";
                } else {
                    userAnswers[count][0] = optGroup.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }
    public void start(int count){
        qNo.setText(count+1+".");
        question.setText(Questions[count][0]);

        option1.setText(Questions[count][1]);
        option1.setActionCommand(Questions[count][1]);

        option2.setText(Questions[count][2]);
        option2.setActionCommand(Questions[count][2]);

        option3.setText(Questions[count][3]);
        option1.setActionCommand(Questions[count][3]);

        option4.setText(Questions[count][4]);
        option4.setActionCommand(Questions[count][4]);

        optGroup.clearSelection();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            repaint();
            lifeLine.setVisible(life);
            option1.setEnabled(true);
            option2.setEnabled(true);
            option3.setEnabled(true);
            option4.setEnabled(true);
            given_Ans=1;
            if(optGroup.getSelection()==null){
                userAnswers[count][0]="";
            }else{
                userAnswers[count][0]=optGroup.getSelection().getActionCommand();
            }
            if(count==8){
                next.setVisible(false);
                submit.setVisible(true);
            }
            start(++count);
        }
        else if(e.getSource()==lifeLine){
            life=false;
            if(count==2||count==4||count==6||count==8||count==9){
                option2.setEnabled(false);
                option3.setEnabled(false);
            }else {
                option1.setEnabled(false);
                option4.setEnabled(false);
            }
            lifeLine.setVisible(life);
        } else if (e.getSource()==submit) {
            given_Ans=1;
            if (optGroup.getSelection() == null) {
                userAnswers[count][0] = "";
            } else {
                userAnswers[count][0] = optGroup.getSelection().getActionCommand();
            }
            for(int i=0;i<userAnswers.length;i++){
                System.out.println(score+"!");
                if(userAnswers[i][0].equals(Answers[i][1])){
                    score=score+10;
                }else{
                    score-=-1;
                }
            }
            setVisible(false);
            if(!life){
                new Score(S,score-20);
            }else{
                new Score(S,score);
            }
            count=0;
            score=0;
            life=true;
            dispose();
        }
    }
}
