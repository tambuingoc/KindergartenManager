package com.example.kindergartenmanager.controller;

import com.example.kindergartenmanager.dao.DBUtils;
import com.example.kindergartenmanager.dao.LoginDAO;
import com.example.kindergartenmanager.helper.Helper;
import com.example.kindergartenmanager.model.Notice;
import com.example.kindergartenmanager.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button button_close;

    @FXML
    private Button button_login;

    @FXML
    private Button button_sign_up;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;
    @FXML
    private AnchorPane login_form;
    private LoginDAO loginDAO = new LoginDAO();
    private Notice notice = new Notice();
    public  void close() {
        System.exit(0);
    }
    //CREATE DATABASE
    public void loginUser(ActionEvent event) throws Exception{
        Alert alert;
        if(tf_username.getText().isEmpty()|| tf_password.getText().isEmpty()) {
            notice.errorBlankField();
        } else {
            if(loginDAO.login(event, tf_username.getText(), tf_password.getText())==false) {
                notice.accountNotExist();
            }
        }
    }

    public void changeToSignUp(ActionEvent event) throws Exception {
        Helper.changeScence(event,"signup.fxml", "Sign Up", null, null);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
