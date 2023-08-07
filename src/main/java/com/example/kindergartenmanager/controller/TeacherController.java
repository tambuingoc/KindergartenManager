package com.example.kindergartenmanager.controller;

import com.example.kindergartenmanager.dao.StudentDAO;
import com.example.kindergartenmanager.model.Student;
import com.example.kindergartenmanager.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private TableColumn<?, ?> student_col_class;

    @FXML
    private Button analysis;

    @FXML
    private AnchorPane attendance_form;

    @FXML
    private Button button_export;

    @FXML
    private Button button_save;

    @FXML
    private Button classlist;

    @FXML
    private AnchorPane classlist_form;

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
    private ComboBox<?> attendence_status;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_total_femal_class;

    @FXML
    private Label home_total_male_class;

    @FXML
    private Label home_total_st_class;

    @FXML
    private Button logout;

    @FXML
    private Button minus;

    @FXML
    private Button record;

    @FXML
    private TableColumn<?, ?> st_col_address;

    @FXML
    private TableColumn<?, ?> st_col_class;

    @FXML
    private TableColumn<?, ?> st_col_dob;

    @FXML
    private TableColumn<?, ?> st_col_gender;

    @FXML
    private TableColumn<?, ?> st_col_id;

    @FXML
    private TableColumn<?, ?> st_col_name;

    @FXML
    private TableColumn<?, ?> st_col_paName;

    @FXML
    private TableColumn<?, ?> st_col_phone;

    @FXML
    private TableColumn<?, ?> st_col_status;

    @FXML
    private TableColumn<?, ?> st_col_year;

    @FXML
    private TableColumn<?, ?> student_col_birth;

    @FXML
    private TableColumn<?, ?> student_col_name;

    @FXML
    private TableColumn<?, ?> student_col_status;

    @FXML
    private TableColumn<?, ?> student_col_year;

    @FXML
    private TableView<Student> student_tableView;

    @FXML
    private TableColumn<?, ?> student_col_id;

    @FXML
    private TableView<Student> table_stView;

    @FXML
    private TextField tf_search;

    @FXML
    private Label user;

    private StudentDAO studentDAO = new StudentDAO();

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
//Home form
    public void homeDisplayTotalStudents() {

        int countStudent = studentDAO.countTotalStudentsLa2();
        home_total_st_class.setText(String.valueOf(countStudent));
}
    public void homeDisplayTotalClasses() {
        int countMale = studentDAO.countTotalMaleStudents();
        home_total_male_class.setText(String.valueOf(countMale));
    }
    public void homeDisplayTotalFemale() {
        int countFemale = (studentDAO.countTotalStudentsLa2()-studentDAO.countTotalMaleStudents());
        home_total_femal_class.setText(String.valueOf(countFemale));
    }

    //Show student information in listClass form
    private ObservableList<Student> addStudentsListDLa2;
    private ObservableList<Student> addStudentsListD;
    public void addStudentShowListData() {
        addStudentsListDLa2 = studentDAO.addStudentListDataLa2();

        st_col_id.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        st_col_year.setCellValueFactory(new PropertyValueFactory<>("yearSt"));
        st_col_class.setCellValueFactory(new PropertyValueFactory<>("classNameSt"));
        st_col_name.setCellValueFactory(new PropertyValueFactory<>("nameSt"));
        st_col_gender.setCellValueFactory(new PropertyValueFactory<>("genderSt"));
        st_col_address.setCellValueFactory(new PropertyValueFactory<>("addressSt"));
        st_col_dob.setCellValueFactory(new PropertyValueFactory<>("birthSt"));
        st_col_paName.setCellValueFactory(new PropertyValueFactory<>("parentNameSt"));
        st_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneSt"));
        st_col_status.setCellValueFactory(new PropertyValueFactory<>("statusSt"));

        table_stView.setItems(addStudentsListDLa2);
    }
//ATTENDENCE FORM
    //Show student information in Student Attendance form
    public void showStudentAttendence() {
        addStudentsListD = studentDAO.addStudentListDataLa2();
        student_col_id.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        student_col_year.setCellValueFactory(new PropertyValueFactory<>("yearSt"));
        student_col_class.setCellValueFactory(new PropertyValueFactory<>("classNameSt"));
        student_col_name.setCellValueFactory(new PropertyValueFactory<>("nameSt"));
        student_col_birth.setCellValueFactory(new PropertyValueFactory<>("birthSt"));

        student_tableView.setItems(addStudentsListD);
    }

    //choosen attendence status
    private String[] attendenceStatus = {"có", "vắng", "phép"};
    public void addAttendenceStatus() {
        List<String> status =  new ArrayList<>();
        for(String s : attendenceStatus) {
            status.add(s);
        }
        ObservableList ObList = FXCollections.observableArrayList(status);
        attendence_status.setItems(ObList);
    }

    public void addStudentAttendenceStatus() {

    }
    public void swichForm(ActionEvent event) {
        if(event.getSource() == home) {
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            home_form.setVisible(true);
            classlist_form.setVisible(false);
            attendance_form.setVisible(false);

            homeDisplayTotalStudents();
            homeDisplayTotalFemale();
            homeDisplayTotalClasses();

        } else if(event.getSource() == classlist) {
            classlist.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            record.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            home_form.setVisible(false);
            classlist_form.setVisible(true);
            attendance_form.setVisible(false);
            addStudentShowListData();


        } else if(event.getSource() == record) {

            record.setStyle("-fx-background-color: linear-gradient(to bottom right, #86c3e4, #83dfb4)");
            home.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            classlist.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            analysis.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            grade.setStyle("-fx-background-color:linear-gradient(to bottom right, #5189ac, #50cc8c)");
            home_form.setVisible(false);
            classlist_form.setVisible(false);
            attendance_form.setVisible(true);
            showStudentAttendence();
            addAttendenceStatus();

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
        homeDisplayTotalStudents();
        homeDisplayTotalFemale();
        homeDisplayTotalClasses();
    }
}

