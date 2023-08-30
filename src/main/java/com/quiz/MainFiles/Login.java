package com.quiz.MainFiles;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {
    JButton play,close;
    JTextArea inputName;
    public static void main(String[] args) {
        new Login("");
    }
    public Login(String LoginName){
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("com/quiz/icons/login.jpeg"));
        JLabel image=new JLabel(i);
        image.setBounds(20,80,400,300);
        add(image);
        setSize(900,500);
        setLocation(200,100);
        setVisible(true);

        JLabel heading=new JLabel("Simple");
        heading.setBounds(570,60,300,50);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
        heading.setForeground(Color.blue);
        add(heading);

        JLabel name=new JLabel("Enter Your Name");
        name.setBounds(570,110,300,50);
        name.setFont(new Font("Times New Roman", Font.BOLD,20));
        name.setForeground(Color.blue);
        add(name);

        inputName=new JTextArea();
        inputName.setText(LoginName);
        inputName.setBounds(500,170,300,27);
        inputName.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(inputName);

        play=new JButton("Play");
        play.setBounds(680,250,80,27);
        play.setFont(new Font("Times New Roman", Font.PLAIN,15));
        play.addActionListener(this);
        add(play);

        close=new JButton("Exit");
        close.setBounds(525,250,80,27);
        close.setFont(new Font("Times New Roman", Font.PLAIN,15));
        close.addActionListener(this);
        add(close);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==close){
            setVisible(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }else {
            setVisible(false);
            new Rules(inputName.getText());
        }
        dispose();
    }
}
