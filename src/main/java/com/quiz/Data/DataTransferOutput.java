package com.quiz.Data;

import java.sql.*;

public class DataTransferOutput {
    public ResultSet r;
    public DataTransferOutput(){
        String url="jdbc:mysql://localhost:3306/quiz";
        String user="root";
        String password="";
        String query="SELECT * FROM `quiz`.`Quiz_score` WHERE score<=100 ORDER BY score DESC limit 10";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement s=connection.createStatement();
            this.r= s.executeQuery(query);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
