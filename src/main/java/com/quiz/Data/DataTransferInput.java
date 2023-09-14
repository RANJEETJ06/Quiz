package com.quiz.Data;

import java.sql.*;

public class DataTransferInput {
    public DataTransferInput(String name, int score){
        String url="jdbc:mysql://localhost:3306/quiz";
        String user="root";
        String password="";
        String query="insert into quiz_score(Name,score) values('"+name+"','"+score+"')";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement s=connection.createStatement();
            s.executeUpdate(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
