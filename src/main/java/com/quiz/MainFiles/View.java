package com.quiz.MainFiles;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Objects;
import com.quiz.Data.DataTransferOutput;
import java.sql.ResultSet;

public class View extends JFrame{
    public View() throws SQLException {
        setTitle("Quiz Time");
        ImageIcon logo=new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("com/quiz/icons/ic.png")));
        setIconImage(logo.getImage());
        getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setBounds(240,120,800,500);
        setVisible(true);

        JLabel highest=new JLabel("Top 10 Players");
        highest.setBounds(45,30,700,40);
        highest.setFont(new Font("Tahoma",Font.PLAIN,25));
        highest.setForeground(Color.blue);
        add(highest);

        ResultSet vr=new DataTransferOutput().r;

        while (vr.next()) {
            System.out.print(vr.getInt(1) + "," + vr.getString(2) + "," + vr.getString(3));
            System.out.println();
        }
    }

    public static void main(String[] args) throws SQLException {
        new View();
    }

}
