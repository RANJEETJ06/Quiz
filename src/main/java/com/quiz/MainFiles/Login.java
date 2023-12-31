package com.quiz.MainFiles;


import com.quiz.Data.DataTransferOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {
    JButton play,close;
    JTextArea inputName;
    JLabel error;
    Color words=new Color(226,223,210);
    public static void main(String[] args) {
        new Login("",false);
    }
    public Login(String LoginName,boolean UserCheck){
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        getContentPane().setBackground(new Color(20,66,114));
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("com/quiz/icons/login.jpeg"));
        JLabel image=new JLabel(i);
        image.setBounds(20,80,400,300);
        add(image);
        setSize(900,500);
        setLocation(200,100);
        setVisible(true);

        JLabel heading=new JLabel("Login");
        heading.setBounds(590,90,300,50);
        heading.setFont(new Font("Times New Roman",Font.BOLD,40));
        heading.setForeground(words);
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(570,140,300,50);
        name.setFont(new Font("Times New Roman", Font.BOLD,20));
        name.setForeground(words);
        add(name);

        inputName=new JTextArea();
        inputName.setText(LoginName);
        inputName.setBounds(500,210,300,27);
        inputName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(inputName);

        play=new JButton("Play");
        play.setBounds(680,290,80,27);
        play.setFont(new Font("Times New Roman", Font.PLAIN,15));
        play.addActionListener(this);
        add(play);

        close=new JButton("Exit");
        close.setBounds(525,290,80,27);
        close.setFont(new Font("Times New Roman", Font.PLAIN,15));
        close.addActionListener(this);
        add(close);

        error=new JLabel("*Already Exist Username");
        error.setBounds(500,185,300,27);
        error.setFont(new Font("Times New Roman", Font.BOLD,15));
        error.setForeground(Color.red);
        error.setVisible(UserCheck);
        add(error);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else {
            try{
                ResultSet vr=new DataTransferOutput().r;
                ArrayList<String> m=new ArrayList<>();
                while (vr.next()) {
                    m.add(vr.getString(2));
                }
                if(m.contains(inputName.getText())){
                    new Login(inputName.getText(),true);
                }else {
                    setVisible(false);
                    new Rules(inputName.getText());
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        dispose();
    }
}
