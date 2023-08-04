package com.example.kindergartenmanager.dao;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection connectDb(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-9J07U8P\\SQLEXPRESS:1433;"+"user=sa;password=123;databaseName=Kindergarten;encrypt=true;trustServerCertificate=true";
            Connection connection = DriverManager.getConnection(url);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
