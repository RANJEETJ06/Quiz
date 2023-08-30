package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Rules extends JFrame implements ActionListener {
    JButton back,start;
    String backToLogin;
    public Rules(String s){
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        setSize(1000,500);
        setLocation(200,100);
        setVisible(true);
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        backToLogin=s;

        JLabel welcomeRule=new JLabel("WelCome to Quiz Party "+s+"!");
        welcomeRule.setBounds(40,20,700,50);
        welcomeRule.setFont(new Font("Times New Roman",Font.BOLD,30));
        welcomeRule.setForeground(Color.blue);
        add(welcomeRule);

        JLabel rules=new JLabel();
        rules.setText("<html>"+
                "1. You are trained to be a programmer and not a story teller, answer point to point" + "<br><br>" +
                "2. Do not unnecessarily smile at the person sitting next to you, they may also not know the answer" + "<br><br>" +
                "3. You may have lot of options in life but here all the questions are compulsory" + "<br><br>" +
                "4. Crying is allowed but please do so quietly." + "<br><br>" +
                "5. Only a fool asks and a wise answers (Be wise, not otherwise)" + "<br><br>" +
                "6. Do not get nervous if your friend is answering more questions, may be he/she is doing Jai Mata Di" + "<br><br>" +
                "7. Brace yourself, this paper is not for the faint hearted" + "<br><br>" +
                "8. May you know more than what John Snow knows, Good Luck" + "<br><br>" +
                "<html>"
        );
        rules.setBounds(20,90,660,350);
        rules.setFont(new Font("Times New Roman",Font.PLAIN,13));
        rules.setForeground(Color.blue);
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
            new Login(backToLogin);
        }else{
            setVisible(false);
            new Quiz(backToLogin);
        }
        dispose();
    }
}

