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
//                String url = "jdbc:sqlserver://DESKTOP-9J07U8P\\SQLEXPRESS:1433;"+"user=sa;password=123;databaseName=Kindergarten;encrypt=true;trustservercertificate=true;connectTimeout=1;connection_limit=1000";
                String url = "jdbc:sqlserver://DESKTOP-9J07U8P\\SQLEXPRESS:1433;"+"user=sa;password=123;databaseName=Kindergarten;encrypt=true;trustServerCertificate=true";
                con = DriverManager.getConnection(url);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }




}
