package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    public static Connection con;

    public DAO() {
        if(con==null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://127.0.0.1:1433;database=Kindergarten;user=sa;password=123456;trustservercertificate=true;connectTimeout=1;connection_limit=1000";
                con = DriverManager.getConnection(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




}
