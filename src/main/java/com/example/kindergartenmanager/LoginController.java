package com.example.kindergartenmanager;

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

import java.io.IOException;
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
    public  void close() {
        System.exit(0);
    }
    //CREATE DATABASE
    public void loginUser() throws Exception {
        Connection connect = null;
        PreparedStatement prepare = null;
        ResultSet result = null;

        String sql = "SELECT * FROM [Users] WHERE username = ? and password = ?";

        try {
            connect = DBUtils.connectDb();
            if(connect != null){
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, tf_username.getText());
                prepare.setString(2, tf_password.getText());

                result = prepare.executeQuery();
                //CHECK FIELDS ARE EMPTY ?
                if(tf_username.getText().isEmpty() || tf_password.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();
                } else {
                    if(result.next()) {
                        //To get username  that you logined
                        User.username = result.getString("username");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Login!");
                        alert.showAndWait();

                        //TO HIDE THE LOGIN FORM
                        button_login.getScene().getWindow().hide();
                        //LINK DASHBROAD
                        Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Wrong Username/Password");
                        alert.showAndWait();
                    }
                }
            }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(connect != null) {
                    try {
                        connect.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(prepare != null) {
                    try {
                        prepare.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(result != null) {
                    try {
                        result.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void changeToSignUp() throws Exception {
            button_sign_up.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //Nếu ấn nút signup sẽ thay đổi cảnh sang trang đanq ký
                    DBUtils.changeScence(event, "signup.fxml", "Sign Up", null, null);
                }
            });
        }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
