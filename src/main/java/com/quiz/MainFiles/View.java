package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;
import com.quiz.Data.DataTransferOutput;
import com.quiz.Data.Node;
import java.sql.ResultSet;
import java.util.PriorityQueue;

public class View extends JFrame implements ActionListener{
    JButton again,close;
    Color words=new Color(226,223,210);
    Color bg=new Color(20,66,114);
    public View() throws SQLException {
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        getContentPane().setBackground(bg);
        setLayout(null);
        setBounds(240,120,800,500);
        setVisible(true);

        JLabel highest=new JLabel("Top 10 Players:");
        highest.setBounds(45,30,700,40);
        highest.setFont(new Font("Tahoma",Font.PLAIN,25));
        highest.setForeground(words);
        add(highest);

        JLabel name=new JLabel("Name");
        name.setBounds(53,65,200,40);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        name.setForeground(words);
        add(name);

        JLabel score=new JLabel("Score");
        score.setBounds(253,65,500,40);
        score.setFont(new Font("Tahoma",Font.PLAIN,20));
        score.setForeground(words);
        add(score);

        ResultSet vr=new DataTransferOutput().r;
        PriorityQueue<Node> topScore=new PriorityQueue<>();
        while (vr.next()) {
            topScore.add(new Node(vr.getString(2),vr.getInt(3)));
        }
        JLabel LName,Score;
        int i=0;
        try{
            while(!topScore.isEmpty()){
                Node x=topScore.remove();

                LName=new JLabel(x.getName());
                LName.setBounds(53,90+i,200,40);
                LName.setFont(new Font("Tahoma",Font.PLAIN,20));
                LName.setForeground(words);
                add(LName);

                Score=new JLabel(String.valueOf(x.getScore()));
                Score.setBounds(253,90+i,500,40);
                Score.setFont(new Font("Tahoma",Font.PLAIN,20));
                Score.setForeground(words);
                add(Score);

                i+=23;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        finally{
            again=new JButton("Play Again");
            again.setBounds(460,380,120,30);
            again.addActionListener(this);
            add(again);

            close=new JButton("Close");
            close.setBounds(630,380,120,30);
            close.addActionListener(this);
            add(close);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==again){
            new Login("",false);
        } else {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        setVisible(false);
        dispose();
    }
}
