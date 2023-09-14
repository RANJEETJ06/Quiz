package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;
import com.quiz.Data.DataTransferOutput;
import com.quiz.Data.Node;
import java.sql.ResultSet;
import java.util.PriorityQueue;

public class View extends JFrame{
    public View() throws SQLException {
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setBounds(240,120,800,500);
        setVisible(true);

        JLabel highest=new JLabel("Top 10 Players:");
        highest.setBounds(45,30,700,40);
        highest.setFont(new Font("Tahoma",Font.PLAIN,25));
        highest.setForeground(Color.blue);
        add(highest);

        JLabel name=new JLabel("Name");
        name.setBounds(53,65,200,40);
        name.setFont(new Font("Tahoma",Font.PLAIN,20));
        name.setForeground(Color.blue);
        add(name);

        JLabel score=new JLabel("Score");
        score.setBounds(253,65,500,40);
        score.setFont(new Font("Tahoma",Font.PLAIN,20));
        score.setForeground(Color.blue);
        add(score);

        ResultSet vr=new DataTransferOutput().r;
        PriorityQueue<Node> topScore=new PriorityQueue<>();
        while (vr.next()) {
            topScore.add(new Node(vr.getString(2),vr.getInt(3)));
        }
        while(!topScore.isEmpty()){
            Node x=topScore.remove();
            System.out.print(x.getName()+",");
            System.out.print(x.getScore()+",");
            System.out.println();
        }
    }

    public static void main(String[] args) throws SQLException {
        new View();
    }

}
