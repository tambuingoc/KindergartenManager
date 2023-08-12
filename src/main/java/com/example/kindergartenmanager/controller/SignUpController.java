package com.example.kindergartenmanager.controller;

import com.example.kindergartenmanager.dao.DBUtils;
import com.example.kindergartenmanager.dao.SignUpDAO;
import com.example.kindergartenmanager.helper.Helper;
import com.example.kindergartenmanager.model.Notice;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpController implements Initializable {
    @FXML
    private Button button_close;

    @FXML
    private Button button_log_in;

    @FXML
    private Button button_signup;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private TextField tf_email;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_username;
    private SignUpDAO signUpDAO = new SignUpDAO();
    private Notice notice = new Notice();

    @FXML
    public void close() {
        System.exit(0);
    }

    public boolean validEmail() {
        //EXAMPLE: tam10@gmail.com [FIRST LETTER] [2ND LETTER TO NUMBER] @ [gamil] . [com]
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");

        Matcher match = pattern.matcher(tf_email.getText());

        if(match.find() && match.group().equals(tf_email.getText())){

            return true;

        }else{
            notice.invalidEmail();
            return false;

        }
    }
    public void signupUser(ActionEvent event) {
        Alert alert;
        if (tf_username.getText().isEmpty() || tf_password.getText().isEmpty() || tf_email.getText().isEmpty()) {
            notice.errorBlankField();

        } else {

            if (validEmail()) {
                if (signUpDAO.signup(event, tf_username.getText(), tf_password.getText(), tf_email.getText())) {
                    notice.successSignUp();
                    Helper.changeScence(event, "login.fxml");
                } else {
                    notice.accountExist();
                }
            }
        }
    }

    public void changeToLogin(ActionEvent event) {
        Helper.changeScence(event, "login.fxml", "Login", null, null);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
