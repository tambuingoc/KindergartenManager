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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email");
            alert.showAndWait();

            return false;

        }
    }
    public void signup() throws Exception {
        Connection connect = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExits = null;
        ResultSet result = null;

        //Thêm tài khoản mới
        String sql1 = "INSERT INTO [Users] (username, password, email) VALUES(?,?,?)";
        //Kiểm tra tài khoản tồn tại hay chưa (tiêu chí: tên đăng nhâp)
        String sql2 = "SELECT * FROM [Users] WHERE username = ?";

        try {
            connect = DBUtils.connectDb();
            if(connect != null) {
                psCheckUserExits = connect.prepareCall(sql2);
                psCheckUserExits.setString(1, tf_username.getText());
                result = psCheckUserExits.executeQuery();

                if(tf_username.getText().isEmpty() || tf_password.getText().isEmpty() || tf_email.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all the blank fields");
                    alert.showAndWait();
                } else if(result.isBeforeFirst()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Username has exits!");
                    alert.showAndWait();
                }  else {
                    if(validEmail()){
                        psInsert = connect.prepareStatement(sql1);
                        psInsert.setString(1, tf_username.getText());
                        psInsert.setString(2, tf_password.getText());
                        psInsert.setString(3, tf_email.getText());
                        psInsert.executeUpdate();
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Sign Up");
                        alert.showAndWait();

                        button_signup.getScene().getWindow().hide();
                        //LINK DASHBROAD
                        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);
                        stage.show();
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

            if(psInsert != null) {
                try {
                    psInsert.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if(psCheckUserExits != null) {
                try {
                    psCheckUserExits.close();
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

    public void changeToLogin() {
        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScence(event, "login.fxml", "Login", null, null);
            }
        });
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
