package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Rules extends JFrame implements ActionListener {
    JButton back,start;
    String backToLogin;
    Color words=new Color(226,223,210);
    public Rules(String s){
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        setSize(1000,500);
        setLocation(200,100);
        setVisible(true);
        getContentPane().setBackground(new Color(20,66,114));
        setLayout(null);
        backToLogin=s;

        JLabel welcomeRule=new JLabel("WelCome to Quiz Party "+s+"!");
        welcomeRule.setBounds(40,20,700,50);
        welcomeRule.setFont(new Font("Times New Roman",Font.BOLD,30));
        welcomeRule.setForeground(words);
        add(welcomeRule);

        JLabel rules=new JLabel();
        rules.setText("<html>"+
                "1. The quiz is on Java Programming Language" + "<br><br>" +
                "2. The quiz consists of 10 questions" + "<br><br>" +
                "3. Each correct answer earns the participant 10 points." + "<br><br>" +
                "4. Each incorrect answer results in a deduction of 1 point" + "<br><br>" +
                "5. Participants have 15 seconds to answer each question" + "<br><br>" +
                "6. Answers must be submitted within the allocated time,Unanswered questions at the end of the time limit are considered 0." + "<br><br>" +
                "7. Participants have one lifeline for all 10 questions," +
                "Lifeline deducts 20 points" + "<br><br>" +
                "8. Lifeline reveals and hides two wrong options, leaving two answer choices" + "<br><br>" +
                "<html>"
        );
        rules.setBounds(20,90,660,350);
        rules.setFont(new Font("Times New Roman",Font.PLAIN,13));
        rules.setForeground(words);
        add(rules);

        start=new JButton("Start");
        start.setBounds(850,400,100,30);
        start.setFont(new Font("Times New Roman",Font.PLAIN,18));
        start.addActionListener(this);
        add(start);

        back=new JButton("Back");
        back.setBounds(700,400,100,30);
        back.setFont(new Font("Times New Roman",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Login(backToLogin,false);
        }else{
            setVisible(false);
            new Quiz(backToLogin);
        }
        dispose();
    }
}

