package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.helper.Helper;
import com.example.kindergartenmanager.model.Notice;
import com.example.kindergartenmanager.model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO extends DAO{
    public LoginDAO() {
        super();
    }
    public boolean login(ActionEvent event, String userName, String password) {
        String sqlAdmin = "SELECT * FROM [Users] WHERE username = ? and password = ?";
        String sqlTeacher = "SELECT * FROM [Teachers] WHERE username = ? and password = ?";
        Notice notice = new Notice();
        try {
            if (DAO.con != null) {
                PreparedStatement prepareAdmin = con.prepareStatement(sqlAdmin);
                prepareAdmin.setString(1, userName);
                prepareAdmin.setString(2, password);
                ResultSet resultAdmin = prepareAdmin.executeQuery();

                PreparedStatement prepareTeacher = con.prepareStatement(sqlTeacher);
                prepareTeacher.setString(1, userName);
                prepareTeacher.setString(2, password);
                ResultSet resultTeacher = prepareTeacher.executeQuery();

                if (resultAdmin.next()) {
                    //Check admin account?
                    User.username = resultAdmin.getString("username");
                    notice.successLogin();
                    //go to admin form
                    Helper.changeScence(event, "admin.fxml");
                    return true;


                } else if (resultTeacher.next()) {
                    //teacher account?
                     User.username = resultTeacher.getString("username");
                     notice.successLogin();
                     Helper.changeScence(event, "teacher.fxml");
                     return true;
                    }
                }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }
}
