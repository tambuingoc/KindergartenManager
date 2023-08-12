package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.helper.Helper;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.example.kindergartenmanager.dao.DAO.con;

public class SignUpDAO {
    public SignUpDAO() {
        super();
    }

    public boolean isUserExist(String userName) throws SQLException {
        //Kiểm tra tài khoản tồi tại chưa (tiêu chí: tên đang nhập)
        String sql2 = "SELECT * FROM [Users] WHERE username = ?";
        PreparedStatement psCheckUserExits = con.prepareCall(sql2);
        psCheckUserExits.setString(1, userName);
        ResultSet result = psCheckUserExits.executeQuery();
        if (result.isBeforeFirst()) {
            return true;
        }
        else return false;
    }
    public boolean signup(ActionEvent event, String userName, String password, String email) {
        String sql1 = "INSERT INTO [Users] (username, password, email) VALUES(?,?,?)";
        try {
            if (con != null) {
                if (isUserExist(userName) == false) {
                    PreparedStatement psInsert = con.prepareStatement(sql1);
                    psInsert.setString(1, userName);
                    psInsert.setString(2, password);
                    psInsert.setString(3, email);
                    psInsert.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }
}

