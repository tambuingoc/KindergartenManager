package com.example.kindergartenmanager.controller;

import com.example.kindergartenmanager.dao.DBUtils;
import com.example.kindergartenmanager.dao.StudentDAO;
import com.example.kindergartenmanager.dao.getData;
import com.example.kindergartenmanager.model.Classroom;
import com.example.kindergartenmanager.model.Student;
import com.example.kindergartenmanager.model.Teacher;
import com.example.kindergartenmanager.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class AdminController implements Initializable {

    @FXML
    private Button button_class;

    @FXML
    private Button button_classAdd;

    @FXML
    private Button button_classClear;

    @FXML
    private Button button_classDelete;

    @FXML
    private Button button_classUpdate;

    @FXML
    private Button button_close;

    @FXML
    private Button button_editAvatar;

    @FXML
    private Button button_home;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_minus;

    @FXML
    private Button button_schedule;

    @FXML
    private Button button_student;

    @FXML
    private Button button_studentAdd;

    @FXML
    private Button button_studentClear;

    @FXML
    private Button button_studentDelete;

    @FXML
    private Button button_studentImage;

    @FXML
    private Button button_studentUpdate;

    @FXML
    private Button button_teacher;

    @FXML
    private Button button_teacherAdd;

    @FXML
    private Button button_teacherClear;

    @FXML
    private Button button_teacherDelete;

    @FXML
    private Button button_teacherImage;

    @FXML
    private Button button_teacherUpdate;

    @FXML
    private ComboBox<?> cb_classTeacherName;

    @FXML
    private ComboBox<?> cb_classYear;

    @FXML
    private ComboBox<?> cb_studentClass;

    @FXML
    private ComboBox<?> cb_studentGender;

    @FXML
    private ComboBox<?> cb_studentStatus;

    @FXML
    private ComboBox<?> cb_studentYear;

    @FXML
    private ComboBox<?> cb_teacherClassID;

    @FXML
    private ComboBox<?> cb_teacherDegree;

    @FXML
    private ComboBox<?> cb_teacherGender;

    @FXML
    private Circle circle_avatar;

    @FXML
    private TableColumn<?, ?> class_col_id;

    @FXML
    private TableColumn<Classroom, String> class_col_name;

    @FXML
    private TableColumn<Classroom, Integer> class_col_quality;

    @FXML
    private TableColumn<Classroom, String> class_col_room;

    @FXML
    private TableColumn<Classroom, String> class_col_teacherName;

    @FXML
    private TableColumn<Classroom, String> class_col_year;

    @FXML
    private AnchorPane class_form;

    @FXML
    private TextField class_search;

    @FXML
    private TableView<Classroom> class_tableView;

    @FXML
    private DatePicker dt_studentDoB;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalClass;

    @FXML
    private LineChart<?, ?> home_totalClassChart;

    @FXML
    private Label home_totalStudent;

    @FXML
    private BarChart<?, ?> home_totalStudentChart;

    @FXML
    private Label home_totalTeacher;

    @FXML
    private LineChart<?, ?> home_totalTeacherChart;

    @FXML
    private Label label_user;

    @FXML
    private AnchorPane main_form;

    @FXML
    private AnchorPane schedule_form;

    @FXML
    private TableColumn<Student, String> student_col_phone;

    @FXML
    private TableColumn<Student, Date> student_col_DoB;

    @FXML
    private TableColumn<Student, Integer> student_col_ID;

    @FXML
    private TableColumn<Student, String> student_col_address;

    @FXML
    private TableColumn<Student, String> student_col_class;

    @FXML
    private TableColumn<Student, String> student_col_gender;

    @FXML
    private TableColumn<Student, String> student_col_name;

    @FXML
    private TableColumn<Student, String> student_col_parent;

    @FXML
    private TableColumn<Student, String> student_col_status;

    @FXML
    private TableColumn<Student, String> student_col_year;

    @FXML
    private AnchorPane student_form;

    @FXML
    private ImageView student_imageView;

    @FXML
    private TextField student_search;

    @FXML
    private TableView<Student> student_tableView;

    @FXML
    private TableColumn<Teacher, Integer> teacher_col_ID;

    @FXML
    private TableColumn<Teacher, String> teacher_col_IDCard;

    @FXML
    private TableColumn<Teacher, String> teacher_col_address;

    @FXML
    private TableColumn<Teacher, String> teacher_col_classID;

    @FXML
    private TableColumn<Teacher, String> teacher_col_degree;

    @FXML
    private TableColumn<Teacher, Date> teacher_col_dob;

    @FXML
    private TableColumn<Teacher, String> teacher_col_gender;

    @FXML
    private TableColumn<Teacher, String> teacher_col_name;

    @FXML
    private TableColumn<Teacher, String> teacher_col_phone;

    @FXML
    private TableColumn<Teacher, Float> teacher_col_salary;

    @FXML
    private AnchorPane teacher_form;

    @FXML
    private ImageView teacher_imageView;

    @FXML
    private TextField teacher_search;

    @FXML
    private TableView<Teacher> teacher_tableView;

    @FXML
    private TextField tf_classID;

    @FXML
    private TextField tf_className;

    @FXML
    private TextField tf_classQualityStudent;

    @FXML
    private TextField tf_classRoom;

    @FXML
    private TextField tf_classTeacherName;

    @FXML
    private TextField tf_studentAddress;

    @FXML
    private TextField tf_studentID;

    @FXML
    private TextField tf_studentName;

    @FXML
    private TextField tf_studentParent;

    @FXML
    private TextField tf_studentPhone;

    @FXML
    private TextField tf_teacherAddress;

    @FXML
    private DatePicker tf_teacherDoB;

    @FXML
    private TextField tf_teacherID;

    @FXML
    private TextField tf_teacherName;

    @FXML
    private TextField tf_teacherPhone;

    @FXML
    private TextField tf_teacherSalary;

    @FXML
    private TextField tf_teacher_IDCard;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

    private StudentDAO studentDAO = new StudentDAO();



    public boolean validateStudent() {
        Alert alert;
        if (tf_studentID.getText().isEmpty()
                || cb_studentYear.getSelectionModel().getSelectedItem() == null
                || cb_studentClass.getSelectionModel().getSelectedItem() == null
                || tf_studentName.getText().isEmpty()
                || cb_studentGender.getSelectionModel().getSelectedItem() == null
                || tf_studentAddress.getText().isEmpty()
                || dt_studentDoB.getValue() == null
                || tf_studentParent.getText().isEmpty()
                || tf_studentPhone.getText().isEmpty()
                || cb_studentStatus.getSelectionModel().getSelectedItem() == null
                || getData.path == null || getData.path == "") {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the blank fields");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    //Process add button in Student form
    //Thêm 1 học sinh mới vào bảng Student
    public void addStudentAdd() {
        try {
            Alert alert;
            if (validateStudent() == false) return;

            //CHECK STUDENT EXITS?
            if (studentDAO.isStudentExist(tf_studentID.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Student # " + tf_studentID.getText() + " was already exited!");
                alert.showAndWait();
            } else {
                // Create student object then call addStudent method
                Student student = new Student();
                student.setStudentNum(Integer.parseInt(tf_studentID.getText()));
                student.setYearSt((String) cb_studentYear.getSelectionModel().getSelectedItem());
                student.setClassNameSt((String) cb_studentClass.getSelectionModel().getSelectedItem());
                student.setNameSt(tf_studentName.getText());
                student.setGenderSt((String) cb_studentGender.getSelectionModel().getSelectedItem());
                student.setAddressSt(tf_studentAddress.getText());
                student.setBirthSt(java.sql.Date.valueOf(dt_studentDoB.getValue()));
                student.setParentNameSt(tf_studentParent.getText());
                student.setPhoneSt(tf_studentPhone.getText());
                student.setStatusSt((String) cb_studentStatus.getSelectionModel().getSelectedItem());
                String uri = getData.path;
                uri = uri.replace("\\", "\\\\");
                student.setImageSt(uri);

                boolean result = studentDAO.createStudent(student);

                if (result == false) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Add Student Failed!");
                    alert.showAndWait();
                }


                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();
                //TO UPDATE THE TABLEVIEW
                addStudentShowListData();
                //TO CLEAR THE FIELDS
                addStudentClear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process clear button
    public void addStudentClear() {
        tf_studentID.setText("");
        cb_studentYear.getSelectionModel().clearSelection();
        cb_studentClass.getSelectionModel().clearSelection();
        tf_studentName.setText("");
        cb_studentGender.getSelectionModel().clearSelection();
        tf_studentAddress.setText("");
        dt_studentDoB.setValue(null);
        tf_studentParent.setText("");
        tf_studentPhone.setText("");
        cb_studentStatus.getSelectionModel().clearSelection();
        student_imageView.setImage(null);

        getData.path = "";
    }

    //Process with update button
    public void addStudentUpdate() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE Students SET "
                + "yearSt = '" + cb_studentYear.getSelectionModel().getSelectedItem()
                + "', classNameSt = '" + cb_studentClass.getSelectionModel().getSelectedItem()
                + "', nameSt = '" + tf_studentName.getText()
                + "', genderSt = '" + cb_studentGender.getSelectionModel().getSelectedItem()
                + "', addressSt = '" + tf_studentAddress.getText()
                + "', birthSt = '" + dt_studentDoB.getValue()
                + "', parentNameSt = '" + tf_studentParent.getText()
                + "', phoneSt = '" + tf_studentPhone.getText()
                + "', statusSt = '" + cb_studentStatus.getSelectionModel().getSelectedItem()
                + "', imageSt = '" + uri + "' WHERE studentNum = '"
                + tf_studentID.getText() + "'";
        connect = DBUtils.connectDb();

        try {
            Alert alert;
            if (tf_studentID.getText().isEmpty()
                    || cb_studentYear.getSelectionModel().getSelectedItem() == null
                    || cb_studentClass.getSelectionModel().getSelectedItem() == null
                    || tf_studentName.getText().isEmpty()
                    || cb_studentGender.getSelectionModel().getSelectedItem() == null
                    || tf_studentAddress.getText().isEmpty()
                    || dt_studentDoB.getValue() == null
                    || tf_studentParent.getText().isEmpty()
                    || tf_studentPhone.getText().isEmpty()
                    || cb_studentStatus.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + tf_studentID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addStudentShowListData();
                    //TO CLEAR THE FIELDS
                    addStudentClear();
                } else {
                    return;
                }
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process with delete button
    public void addStudentDelete() {
        String deleteData = "DELETE FROM Students WHERE studentNum = '"
                + tf_studentID.getText() + "'";

        connect = DBUtils.connectDb();
        try {
            Alert alert;
            if (tf_studentID.getText().isEmpty()
                    || cb_studentYear.getSelectionModel().getSelectedItem() == null
                    || cb_studentClass.getSelectionModel().getSelectedItem() == null
                    || tf_studentName.getText().isEmpty()
                    || cb_studentGender.getSelectionModel().getSelectedItem() == null
                    || tf_studentAddress.getText().isEmpty()
                    || dt_studentDoB.getValue() == null
                    || tf_studentParent.getText().isEmpty()
                    || tf_studentPhone.getText().isEmpty()
                    || cb_studentStatus.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student #" + tf_studentID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addStudentShowListData();
                    //TO CLEAR THE FIELDS
                    addStudentClear();


                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process search fields (Search Student)
    public void addStudentSearch() {
        FilteredList<Student> filter = new FilteredList<>(addStudentsListD, e -> true);

        student_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateStudentData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateStudentData.getStudentNum().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getYearSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getAddressSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getBirthSt().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getClassNameSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getNameSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGenderSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getParentNameSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getPhoneSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStatusSt().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        //SẮP XẾP DANH SÁCH HỌC SINH ĐƯỢC TÌM KIẾM THEO THEO BẢNG CHỮ CÁI A-Z
        SortedList<Student> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(student_tableView.comparatorProperty());
        student_tableView.setItems(sortList);
    }

    //Insert Image of Student
    public void addStudentInsertImage() throws MalformedURLException {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());
        if (file != null) {
            image = new Image(file.toURL().toString(), 127, 150, false, true);
            student_imageView.setImage(image);
            getData.path = file.getAbsolutePath();

        }

    }

    //Add year to student
    private String[] yearList = {"K1", "K2", "K3", "K4", "K5"};

    public void addStudentYearList() {
        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        cb_studentYear.setItems(ObList);
    }

    //Add class for Student lấy từ bảng class
    public void addStudentClassList() {
        String listClass = "SELECT * from Classrooms";
        connect = DBUtils.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listClass);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
            cb_studentClass.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Add gender to student
    private String[] genderList = {"Nam", "Nữ"};

    public void addStudentGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        cb_studentGender.setItems(ObList);
    }

    //Add status to student
    private String[] statusList = {"Học", "Tốt nghiệp", "Thôi học"};

    public void addStudentStatusList() {
        List<String> statusL = new ArrayList<>();

        for (String data : statusList) {
            statusL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(statusL);
        cb_studentStatus.setItems(ObList);
    }

    public ObservableList<Student> addStudentListData() {

        ObservableList<Student> listStudents = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Students";
        connect = DBUtils.connectDb();

        try {
            Student studentD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                studentD = new Student(result.getInt("studentNum"),
                        result.getString("yearSt"),
                        result.getString("classNameSt"),
                        result.getString("nameSt"),
                        result.getString("genderSt"),
                        result.getString("addressSt"),
                        result.getDate("birthSt"),
                        result.getString("parentNameSt"),
                        result.getString("phoneSt"),
                        result.getString("statusSt"),
                        result.getString("imageSt"));

                listStudents.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listStudents;
    }

    private ObservableList<Student> addStudentsListD;

    public void addStudentShowListData() {
        addStudentsListD = addStudentListData();

        student_col_ID.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        student_col_year.setCellValueFactory(new PropertyValueFactory<>("yearSt"));
        student_col_class.setCellValueFactory(new PropertyValueFactory<>("classNameSt"));
        student_col_name.setCellValueFactory(new PropertyValueFactory<>("nameSt"));
        student_col_gender.setCellValueFactory(new PropertyValueFactory<>("genderSt"));
        student_col_address.setCellValueFactory(new PropertyValueFactory<>("addressSt"));
        student_col_DoB.setCellValueFactory(new PropertyValueFactory<>("birthSt"));
        student_col_parent.setCellValueFactory(new PropertyValueFactory<>("parentNameSt"));
        student_col_phone.setCellValueFactory(new PropertyValueFactory<>("phoneSt"));
        student_col_status.setCellValueFactory(new PropertyValueFactory<>("statusSt"));

        student_tableView.setItems(addStudentsListD);
    }

    //Khi kích chọn vào hàng trong bảng TableView thì nó sẽ thêm thông tin vào các trường bên dưới (ảnh, tên...)

    public void addStudentSelect() {
        Student studentD = student_tableView.getSelectionModel().getSelectedItem();
        int num = student_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        tf_studentID.setText(String.valueOf(studentD.getStudentNum()));
        tf_studentName.setText(String.valueOf(studentD.getNameSt()));
        tf_studentAddress.setText(String.valueOf(studentD.getAddressSt()));
        tf_studentParent.setText(String.valueOf(studentD.getParentNameSt()));
        tf_studentPhone.setText(String.valueOf(studentD.getPhoneSt()));
        dt_studentDoB.setValue(LocalDate.parse(String.valueOf(studentD.getBirthSt())));
        String urli = "file:" + studentD.getImageSt();
        image = new Image(urli, 127, 150, false, true);
        student_imageView.setImage(image);

        getData.path = studentD.getImageSt();

    }


    //LÀM VIỆC VỚI TEACHER FORM
    //Process Add button
    public void addTeacherAdd() {
        String insertData = "INSERT INTO Teachers (teacherNum, name, gender, address, phone, dob, cardID, degree, className, salary, image) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        connect = DBUtils.connectDb();
        try {
            Alert alert;
            if (tf_teacherID.getText().isEmpty()
                    || tf_teacherName.getText().isEmpty()
                    || cb_teacherGender.getSelectionModel().getSelectedItem() == null
                    || tf_teacherAddress.getText().isEmpty()
                    || tf_teacherPhone.getText().isEmpty()
                    || tf_teacherDoB.getValue() == null
                    || tf_teacher_IDCard.getText().isEmpty()
                    || cb_teacherDegree.getSelectionModel().getSelectedItem() == null
                    || cb_teacherClassID.getSelectionModel().getSelectedItem() == null
                    || tf_teacherSalary.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                //CHECK TEACHER EXITS?
                String checkData = " SELECT teacherNum FROM Teachers WHERE teacherNum = '"
                        + tf_teacherID.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher # " + tf_teacherID.getText() + " was already exited!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, tf_teacherID.getText());
                    prepare.setString(2, tf_teacherName.getText());
                    prepare.setString(3, (String) cb_teacherGender.getSelectionModel().getSelectedItem());
                    prepare.setString(4, tf_teacherAddress.getText());
                    prepare.setString(5, tf_teacherPhone.getText());
                    prepare.setString(6, String.valueOf(tf_teacherDoB.getValue()));
                    prepare.setString(7, tf_teacher_IDCard.getText());
                    prepare.setString(8, (String) cb_teacherDegree.getSelectionModel().getSelectedItem());
                    prepare.setString(9, (String) cb_teacherClassID.getSelectionModel().getSelectedItem());
                    prepare.setString(10, tf_teacherSalary.getText());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(11, uri);

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    //TO UPDATE THE TABLEVIEW
                    addTeacherListData();
                    //TO CLEAR THE FIELDS
                    addStudentClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process clearn button in Teacher form
    public void addTeacherClear() {
        tf_teacherID.setText("");
        tf_teacherName.setText("");
        cb_teacherGender.getSelectionModel().clearSelection();
        tf_teacherAddress.setText("");
        tf_teacherPhone.setText("");
        tf_teacherDoB.setValue(null);
        tf_teacher_IDCard.setText("");
        cb_teacherDegree.getSelectionModel().clearSelection();
        cb_teacherClassID.getSelectionModel().clearSelection();
        tf_teacherSalary.setText("");
        teacher_imageView.setImage(null);
        getData.path = "";
    }

    //Process update button in Teacher form
    public void addTeacherUpdate() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE Teachers SET "
                + "name = '" + tf_teacherName.getText()
                + "', gender = '" + cb_teacherGender.getSelectionModel().getSelectedItem()
                + "', address = '" + tf_teacherAddress.getText()
                + "', phone = '" + tf_teacherPhone.getText()
                + "', dob = '" + tf_teacherDoB.getValue()
                + "', cardID = '" + tf_teacher_IDCard.getText()
                + "', degree = '" + cb_teacherDegree.getSelectionModel().getSelectedItem()
                + "', className = '" + cb_teacherClassID.getSelectionModel().getSelectedItem()
                + "', salary = '" + tf_teacherSalary.getText()
                + "', image = '" + uri + "' WHERE teacherNum = '"
                + tf_teacherID.getText() + "'";
        connect = DBUtils.connectDb();

        try {
            Alert alert;
            if (tf_teacherID.getText().isEmpty()
                    || tf_teacherName.getText().isEmpty()
                    || cb_teacherGender.getSelectionModel().getSelectedItem() == null
                    || tf_teacherAddress.getText().isEmpty()
                    || tf_teacherPhone.getText().isEmpty()
                    || tf_teacherDoB.getValue() == null
                    || tf_teacher_IDCard.getText().isEmpty()
                    || cb_teacherDegree.getSelectionModel().getSelectedItem() == null
                    || cb_teacherClassID.getSelectionModel().getSelectedItem() == null
                    || tf_teacherSalary.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Teacher #" + tf_teacherID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addTeacherListData();
                    //TO CLEAR THE FIELDS
                    addTeacherClear();
                } else {
                    return;
                }
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process delete button in Teacher form
    public void addTeacherDelete() {
        String deleteData = "DELETE FROM Teachers WHERE teacherNum = '"
                + tf_teacherID.getText() + "'";

        connect = DBUtils.connectDb();
        try {
            Alert alert;
            if (tf_teacherID.getText().isEmpty()
                    || tf_teacherName.getText().isEmpty()
                    || cb_teacherGender.getSelectionModel().getSelectedItem() == null
                    || tf_teacherAddress.getText().isEmpty()
                    || tf_teacherPhone.getText().isEmpty()
                    || tf_teacherDoB.getValue() == null
                    || tf_teacher_IDCard.getText().isEmpty()
                    || cb_teacherDegree.getSelectionModel().getSelectedItem() == null
                    || cb_teacherClassID.getSelectionModel().getSelectedItem() == null
                    || tf_teacherSalary.getText().isEmpty()
                    || getData.path == null || getData.path == "") {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Teacher #" + tf_teacherID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addTeacherShowListData();
                    //TO CLEAR THE FIELDS
                    addTeacherClear();

                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process search field in Teacher form
    public void addTeacherSearch() {
        FilteredList<Teacher> filter = new FilteredList<>(addTeachersListD, e -> true);

        teacher_search.textProperty().addListener((Observable, oldValue, newValue) -> {
            filter.setPredicate(predicateTeacherData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();
                if (predicateTeacherData.getTeacherNum().toString().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getPhone().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getDob().toString().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getCardID().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getDegree().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getClassName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateTeacherData.getSalary().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        //SẮP XẾP DANH SÁCH HỌC SINH ĐƯỢC TÌM KIẾM THEO THEO BẢNG CHỮ CÁI A-Z
        SortedList<Teacher> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(teacher_tableView.comparatorProperty());
        teacher_tableView.setItems(sortList);
    }

    public void addTeacherInsertImage() throws MalformedURLException {
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image File", "*jpg", "*png"));

        File file = open.showOpenDialog(main_form.getScene().getWindow());
        if (file != null) {
            image = new Image(file.toURL().toString(), 130, 147, false, true);
            teacher_imageView.setImage(image);
            getData.path = file.getAbsolutePath();

        }

    }

    //Add gender to Teacher
    public void addTeacherGenderList() {
        List<String> genderL = new ArrayList<>();

        for (String data : genderList) {
            genderL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(genderL);
        cb_teacherGender.setItems(ObList);
    }

    //Add class to teacher
    public void addTeacherClassList() {
        String listClass = "SELECT * from Classrooms";
        connect = DBUtils.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listClass);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
            cb_teacherClassID.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Add degree to teacher
    private String[] degreeList = {"Cao đẳng", "Cử nhân", "Thạc Sỹ"};

    public void addTeacherDegreeList() {
        List<String> degreeL = new ArrayList<>();

        for (String data : degreeList) {
            degreeL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(degreeL);
        cb_teacherDegree.setItems(ObList);
    }

    public ObservableList<Teacher> addTeacherListData() {

        ObservableList<Teacher> listTeachers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Teachers";
        connect = DBUtils.connectDb();

        try {
            Teacher teacherD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                teacherD = new Teacher(result.getInt("teacherNum"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("address"),
                        result.getString("phone"),
                        result.getDate("dob"),
                        result.getString("cardID"),
                        result.getString("degree"),
                        result.getString("className"),
                        result.getFloat("salary"),
                        result.getString("image"));

                listTeachers.add(teacherD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTeachers;
    }

    private ObservableList<Teacher> addTeachersListD;

    public void addTeacherShowListData() {
        addTeachersListD = addTeacherListData();

        teacher_col_ID.setCellValueFactory(new PropertyValueFactory<>("teacherNum"));
        teacher_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        teacher_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        teacher_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        teacher_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        teacher_col_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        teacher_col_IDCard.setCellValueFactory(new PropertyValueFactory<>("cardID"));
        teacher_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        teacher_col_classID.setCellValueFactory(new PropertyValueFactory<>("className"));
        teacher_col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        teacher_tableView.setItems(addTeachersListD);
    }

    //Khi kích chọn vào hàng trong bảng TableView thì nó sẽ thêm thông tin vào các trường bên dưới (ảnh, tên...)
    public void addTeacherSelect() {
        Teacher teacherD = teacher_tableView.getSelectionModel().getSelectedItem();
        int num = teacher_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        tf_teacherID.setText(String.valueOf(teacherD.getTeacherNum()));
        tf_teacherName.setText(String.valueOf(teacherD.getName()));
        tf_teacherAddress.setText(String.valueOf(teacherD.getAddress()));
        tf_teacherDoB.setValue(LocalDate.parse(String.valueOf(teacherD.getDob())));
        tf_teacherPhone.setText(String.valueOf(teacherD.getPhone()));
        tf_teacher_IDCard.setText(String.valueOf(teacherD.getCardID()));
        tf_teacherSalary.setText(String.valueOf(teacherD.getSalary()));

        String uri = "file:" + teacherD.getImage();
        image = new Image(uri, 130, 147, false, true);
        teacher_imageView.setImage(image);

    }

    //LÀM VIỆC VỚI CLASSROOM FORM
    public ObservableList<Classroom> addClassroomListData() {
        ObservableList<Classroom> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Classrooms";
        connect = DBUtils.connectDb();
        try {
            Classroom classroomD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                classroomD = new Classroom(result.getString("name"),
                        result.getInt("quality"),
                        result.getString("room"),
                        result.getString("teacherName"),
                        result.getString("year"));
                listData.add(classroomD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<Classroom> addClassroomList;

    public void addClassroomShowListData() {
        addClassroomList = addClassroomListData();

        class_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        class_col_quality.setCellValueFactory(new PropertyValueFactory<>("quality"));
        class_col_room.setCellValueFactory(new PropertyValueFactory<>("room"));
        class_col_teacherName.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        class_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        class_tableView.setItems(addClassroomList);
    }

    public void addClassroomSelect() {
        Classroom classD = class_tableView.getSelectionModel().getSelectedItem();
        int num = class_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }
        tf_className.setText(String.valueOf(classD.getName()));
        tf_classQualityStudent.setText(String.valueOf(classD.getQuality()));
        tf_classRoom.setText(String.valueOf(classD.getRoom()));
//        tf_classTeacherName.setText(String.valueOf(classD.getTeacherName()));
//        cb_classYear: giải quyết 1 hàm sau
    }

    public void addClassroomYearList() {
        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        cb_classYear.setItems(ObList);
    }

    public void addClassroomAdd() {
        String insertData = "INSERT INTO Classrooms (name, quality, room, teacherName, year) VALUES (?,?,?,?,?)";
        connect = DBUtils.connectDb();
        try {
            Alert alert;
            if (tf_className.getText().isEmpty()
                    || tf_classQualityStudent.getText().isEmpty()
                    || tf_classRoom.getText().isEmpty()
                    || cb_classTeacherName.getSelectionModel().getSelectedItem() == null
                    || cb_classYear.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                //CHECK STUDENT EXITS?
                String checkData = " SELECT name FROM Classrooms WHERE name = '"
                        + tf_className.getText() + "'";
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Classroom # " + tf_className.getText() + " was already exited!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, tf_className.getText());
                    prepare.setString(2, tf_classQualityStudent.getText());
                    prepare.setString(3, tf_classRoom.getText());
                    prepare.setString(4, (String) cb_classTeacherName.getSelectionModel().getSelectedItem());
                    prepare.setString(5, (String) cb_classYear.getSelectionModel().getSelectedItem());

                    prepare.executeUpdate();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    //TO UPDATE THE TABLEVIEW
                    addClassroomShowListData();
                    //TO CLEAR THE FIELDS
                    addClassroomClear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClassroomClear() {
        tf_className.setText("");
        tf_classQualityStudent.setText("");
        tf_classRoom.setText("");
        cb_classTeacherName.getSelectionModel().clearSelection();
        cb_classYear.getSelectionModel().clearSelection();
    }

    public void addClassroomUpdate() {
        String updateData = "UPDATE Students SET "
                + "', name = '" + tf_className.getText()
                + "', quality = '" + tf_classQualityStudent.getText()
                + "', room = '" + tf_classRoom.getText()
                + "', teacherName = '" + cb_classTeacherName.getSelectionModel().getSelectedItem()
                + "', year = '" + cb_classYear.getSelectionModel().getSelectedItem()
                + "'";
        connect = DBUtils.connectDb();

        try {
            Alert alert;
            if (tf_className.getText().isEmpty()
                    || tf_classQualityStudent.getText().isEmpty()
                    || tf_classRoom.getText().isEmpty()
                    || cb_classTeacherName.getSelectionModel().getSelectedItem() == null
                    || cb_classYear.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Classroom " + tf_className.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addClassroomShowListData();
                    //TO CLEAR THE FIELDS
                    addClassroomClear();
                } else {
                    return;
                }
                ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClassroomDelete() {
        String deleteData = "DELETE FROM Classrooms WHERE name = '"
                + tf_className.getText() + "'";

        connect = DBUtils.connectDb();
        try {
            Alert alert;
            if (tf_className.getText().isEmpty()
                    || tf_classQualityStudent.getText().isEmpty()
                    || tf_classRoom.getText().isEmpty()
                    || cb_classTeacherName.getSelectionModel().getSelectedItem() == null
                    || cb_classYear.getSelectionModel().getSelectedItem() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Class " + tf_className.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    //TO DO UPDATE THE TABLEVIEW
                    addClassroomShowListData();
                    //TO CLEAR THE FIELDS
                    addClassroomClear();


                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClassroomTeacherNameList() {
        String listClass = "SELECT * from Teachers";
        connect = DBUtils.connectDb();

        try {

            ObservableList listC = FXCollections.observableArrayList();

            prepare = connect.prepareStatement(listClass);
            result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
            cb_classTeacherName.setItems(listC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Chuyển đổi giữa các form home, student, teacher, class, schedule
    public void swichForm(ActionEvent event) {
        if (event.getSource() == button_home) {
            home_form.setVisible(true);
            student_form.setVisible(false);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            schedule_form.setVisible(false);

            button_home.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_schedule.setStyle("-fx-background-color: transparent");

        } else if (event.getSource() == button_student) {
            home_form.setVisible(false);
            student_form.setVisible(true);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            schedule_form.setVisible(false);

            button_student.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_home.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_schedule.setStyle("-fx-background-color: transparent");

            //TO BECOME UPDATE ONCE YOU CLICK THE ADD STUDENTS BUTTON ON NAV
            addStudentShowListData();
            addStudentYearList();
            addStudentClassList();
            addStudentGenderList();
            addStudentStatusList();
            addStudentSearch();

        } else if (event.getSource() == button_teacher) {
            home_form.setVisible(false);
            student_form.setVisible(false);
            teacher_form.setVisible(true);
            class_form.setVisible(false);
            schedule_form.setVisible(false);

            button_teacher.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_home.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_schedule.setStyle("-fx-background-color: transparent");
            addTeacherShowListData();
            addTeacherGenderList();
            addTeacherDegreeList();
            addTeacherClassList();
            addTeacherSearch();

        } else if (event.getSource() == button_class) {
            home_form.setVisible(false);
            student_form.setVisible(false);
            teacher_form.setVisible(false);
            class_form.setVisible(true);
            schedule_form.setVisible(false);

            button_class.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_home.setStyle("-fx-background-color: transparent");
            button_schedule.setStyle("-fx-background-color: transparent");
            addClassroomShowListData();
            addClassroomTeacherNameList();
            addClassroomYearList();

        } else if (event.getSource() == button_schedule) {
            home_form.setVisible(false);
            student_form.setVisible(false);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            schedule_form.setVisible(true);

            button_schedule.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_home.setStyle("-fx-background-color: transparent");
        }
    }

    public void close() {
        System.exit(0);
    }

    //Display username on admin tag
    public void account() {
        label_user.setText(User.username);
    }

    //Chọn ảnh đại diện cho account
    public void insertAvatar() {

    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }

    //Student.java(Model)
    //ADD STUDENT TO STUDENT_FORM


    public void logout() {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {
                //Hide your dashboard form
                button_logout.getScene().getWindow().hide();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        account();
        //To show immediately when we process to dashboard application form
//        addStudentShowListData();
//        addStudentYearList();
//        addStudentClassList();
//        addStudentGenderList();
//        addStudentStatusList();
    }
}
