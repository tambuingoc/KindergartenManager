package com.example.kindergartenmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.events.MouseEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private TableColumn<?, ?> Student_col_class;

    @FXML
    private Button analysis;

    @FXML
    private Button button_export;

    @FXML
    private Button button_save;

    @FXML
    private Button classlist;

    @FXML
    private Button close;

    @FXML
    private DatePicker date_attend;

    @FXML
    private Button edit;

    @FXML
    private Button grade;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button minus;

    @FXML
    private Button record;

    @FXML
    private TableColumn<?, ?> student_col_address;

    @FXML
    private TableColumn<?, ?> student_col_birth;

    @FXML
    private TableColumn<?, ?> student_col_gender;

    @FXML
    private TableColumn<?, ?> student_col_name;

    @FXML
    private TableColumn<?, ?> student_col_parent;

    @FXML
    private TableColumn<?, ?> student_col_phone;

    @FXML
    private TableColumn<?, ?> student_col_status;

    @FXML
    private TableColumn<?, ?> student_col_year;

    @FXML
    private TableColumn<?, ?> studnet_col_id;

    @FXML
    private TableView<?> student_tableView;

    @FXML
    private Label user;

    public void account() {
        user.setText(User.username);
    }
    public void close() {
        System.exit(0);
    }
    public void logout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get().equals(ButtonType.OK)) {
                //Hide your dashboard form
                logout.getScene().getWindow().hide();

                //Link to login form
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();
            } else return;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void swichForm(ActionEvent event) {
        if(event.getSource() == home) {
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");

        } else if(event.getSource() == classlist) {
            classlist.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");


        } else if(event.getSource() == record) {

            record.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");

        } else if(event.getSource() == analysis) {

            analysis.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");

        } else if(event.getSource() == grade){

            grade.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

