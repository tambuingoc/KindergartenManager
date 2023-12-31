package com.example.kindergartenmanager.controller;

import com.example.kindergartenmanager.dao.*;
import com.example.kindergartenmanager.helper.Helper;
import com.example.kindergartenmanager.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;

public class AdminController implements Initializable {
    @FXML
    private Button button_addYear;
    @FXML
    private Button button_updateYear;

    @FXML
    private Button button_year;

    @FXML
    private Button button_yearClear;

    @FXML
    private Button button_yearDelete;
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
    private TableColumn<?, ?> teacher_col_password;

    @FXML
    private TableColumn<?, ?> teacher_col_username;

    @FXML
    private AnchorPane teacher_form;

    @FXML
    private ImageView teacher_imageView;

    @FXML
    private TextField teacher_search;

    @FXML
    private TableView<Teacher> teacher_tableView;

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
    @FXML
    private TextField tf_teacherUserName;

    @FXML
    private TextField tf_teacherPassword;
    @FXML
    private TextField tf_year;
    @FXML
    private TextField tf_schoolyear;

    @FXML
    private DatePicker date_end;

    @FXML
    private DatePicker date_start;
    @FXML
    private TableView<Year> table_yearView;

    @FXML
    private TableColumn<?, ?> year_col_endDate;

    @FXML
    private TableColumn<?, ?> year_col_id;

    @FXML
    private TableColumn<?, ?> year_col_schoolYear;

    @FXML
    private TableColumn<?, ?> year_col_startDate;

    @FXML
    private AnchorPane year_form;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;

    private StudentDAO studentDAO = new StudentDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private ClassroomDAO classroomDAO = new ClassroomDAO();
    private YearDAO yearDAO = new YearDAO();
    private Notice notice = new Notice();

    public void homeDisplayTotalStudents() {
        int countStudent = studentDAO.countTotalStudents();
        home_totalStudent.setText(String.valueOf(countStudent));
    }

    public void homeDisplayTotalTeachers() {
        int countTeacher = teacherDAO.countTotalTeachers();
        home_totalTeacher.setText(String.valueOf(countTeacher));
    }

    public void homeDisplayTotalClasses() {
        int countClass = classroomDAO.countClassrooms();
        home_totalClass.setText(String.valueOf(countClass));
    }

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
            notice.errorBlankField();
            return false;
        }
        return true;
    }

    public Student createSt() {
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
        return student;
    }

    //Process add button in Student form
    //Add a new student to table
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
                Student student = createSt();
                boolean result = studentDAO.createStudent(student);

                if (result == false) {
                    notice.falseAdd();
                }
                else {
                    notice.successAdd();
                    //TO UPDATE THE TABLEVIEW
                    addStudentShowListData();
                    //TO CLEAR THE FIELDS
                    addStudentClear();
                }
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
        try {
            Alert alert;
            if (tf_studentID.getText().isEmpty()) {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + tf_studentID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Student student = createSt();
                    boolean result = studentDAO.updateStudent(student);

                    if (result == true) {
                        notice.successUpdate();

                        addStudentShowListData();
                        addStudentClear();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process with delete button
    public void addStudentDelete() {
        try {
            Alert alert;
            if (tf_studentID.getText().isEmpty()) {return;}
             else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student #" + tf_studentID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    Student student = createSt();
                    boolean result = studentDAO.deleteStudent(student);
                    if(result == true) {
                        notice.successDelete();

                        addStudentShowListData();
                        addStudentClear();
                    }
                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process search fields (Search Student)
    public void addStudentSearch() {
        FilteredList<Student> filter = new FilteredList<>(addStudentsListD, e -> true);
        String searchKeyword = student_search.getText();
        filter.setPredicate(predicateStudentData -> {
                if (searchKeyword == null || searchKeyword.isEmpty()) {
                    return true;
                }
                String searchKey = searchKeyword.toLowerCase();
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
        ObservableList listC = studentDAO.createClassList();
        cb_studentClass.setItems(listC);
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
    private ObservableList<Student> addStudentsListD;

    public void addStudentShowListData() {
        addStudentsListD = studentDAO.addStudentListData();

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
    //Check teacher valid?
    public boolean validateTeacher() {
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
                || tf_teacherUserName.getText().isEmpty()
                || tf_teacherPassword.getText().isEmpty()
                || getData.path == null || getData.path == "") {
            notice.errorBlankField();
            return false;
        }
        return true;
    }

    public Teacher createNewTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNum(Integer.parseInt(tf_teacherID.getText()));
        teacher.setName(tf_teacherName.getText());
        teacher.setGender((String) cb_teacherGender.getSelectionModel().getSelectedItem());
        teacher.setAddress(tf_teacherAddress.getText());
        teacher.setPhone(tf_teacherPhone.getText());
        teacher.setDob(java.sql.Date.valueOf(tf_teacherDoB.getValue()));
        teacher.setCardID(tf_teacher_IDCard.getText());
        teacher.setDegree((String) cb_teacherDegree.getSelectionModel().getSelectedItem());
        teacher.setClassName((String) cb_teacherClassID.getSelectionModel().getSelectedItem());
        teacher.setSalary(Float.parseFloat(tf_teacherSalary.getText()));
        teacher.setUsername(tf_teacherUserName.getText());
        teacher.setPassword(tf_teacherPassword.getText());
        try {
            String uri = getData.path;
            uri = uri.replace("\\", "\\\\");
            teacher.setImage(uri);
        } catch (Exception e) {

        }
        return teacher;
    }

    //Process Add button
    public void addTeacherAdd() {
        try {
            Alert alert;
            if (validateTeacher() == false) {
                return;
            } else {
                if(teacherDAO.isTeacherExist(tf_teacherID.getText())) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Teacher # " + tf_teacherID.getText() + " was already exited!");
                    alert.showAndWait();
                } else {
                    Teacher teacher = createNewTeacher();
                    boolean result = teacherDAO.createTeacher(teacher);
                    if(result == true) {
                        notice.successAdd();
                        //TO UPDATE THE TABLEVIEW
                        addTeacherShowListData();
                        //TO CLEAR THE FIELDS
                        addStudentClear();
                    }
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
        tf_teacherUserName.setText("");
        tf_teacherPassword.setText("");
    }

    //Process update button in Teacher form
    public void addTeacherUpdate() {
        try {
            Alert alert;
            if (tf_teacherID.getText().isEmpty()) {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Teacher #" + tf_teacherID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Teacher teacher = createNewTeacher();
                    boolean result = teacherDAO.updateTeacher(teacher);

                    if (result) {
                        notice.successUpdate();
                        addTeacherShowListData();
                        addTeacherClear();
                    }
                }else return;
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        }


    //Process delete button in Teacher form
    public void addTeacherDelete() {
        try {
            Alert alert;
            if (tf_teacherID.getText().isEmpty())//teacher_id not null
            {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Teacher #" + tf_teacherID.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    Teacher teacher = createNewTeacher();
                    boolean result = teacherDAO.deleteTeacher(teacher);
                    if(result) {
                        notice.successDelete();
                        addTeacherShowListData();
                        addTeacherClear();
                    }
                }else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process search field in Teacher form
    public void addTeacherSearch() {
        FilteredList<Teacher> filter = new FilteredList<>(addTeachersListD, e -> true);
        String searchKey = teacher_search.getText().toLowerCase();

//        String searchKey = "lá";
        filter.setPredicate(predicateTeacherData -> {
            if (searchKey == null || searchKey.isEmpty()) {
                return true;
            }
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
        System.out.println(searchKey);
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
        ObservableList listC = teacherDAO.createClassList();
        cb_teacherClassID.setItems(listC);

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
    private ObservableList<Teacher> addTeachersListD;

    public void addTeacherShowListData() {
        addTeachersListD = teacherDAO.addTeacherListData();

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
        teacher_col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        teacher_col_password.setCellValueFactory(new PropertyValueFactory<>("password"));

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
        tf_teacherUserName.setText(String.valueOf(teacherD.getUsername()));
        tf_teacherPassword.setText(String.valueOf(teacherD.getPassword()));

        String uri = "file:" + teacherD.getImage();
        image = new Image(uri, 130, 147, false, true);
        teacher_imageView.setImage(image);

    }

    //LÀM VIỆC VỚI CLASSROOM FORM
    private ObservableList<Classroom> addClassroomList;

    public void addClassroomShowListData() {
        addClassroomList = classroomDAO.addClassroomListData();

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
    }

    public void addClassroomYearList() {
        List<String> yearL = new ArrayList<>();

        for (String data : yearList) {
            yearL.add(data);
        }

        ObservableList ObList = FXCollections.observableArrayList(yearL);
        cb_classYear.setItems(ObList);
    }

    public boolean validateClassroom() {
        Alert alert;
        if (tf_className.getText().isEmpty()
                || tf_classQualityStudent.getText().isEmpty()
                || tf_classRoom.getText().isEmpty()
                || cb_classTeacherName.getSelectionModel().getSelectedItem() == null
                || cb_classYear.getSelectionModel().getSelectedItem() == null) {
            notice.errorBlankField();
            return false;
        }
        else {return true;}
    }

    public Classroom createClassroom() {
        Classroom classroom = new Classroom();
        classroom.setName(tf_className.getText());
        classroom.setQuality(Integer.parseInt(tf_classQualityStudent.getText()));
        classroom.setRoom(tf_classRoom.getText());
        classroom.setTeacherName((String) cb_classTeacherName.getSelectionModel().getSelectedItem());
        classroom.setYear((String) cb_classYear.getSelectionModel().getSelectedItem());
        return classroom;
    }

    public void addClassroomAdd() {
        try {
            Alert alert;
            if (validateClassroom() == false) return;
                //CHECK CLASSROOM EXITS?
            if(classroomDAO.isClassroomExist(tf_className.getText())){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Classroom # " + tf_className.getText() + " was already exited!");
                alert.showAndWait();
            } else {
                Classroom classroom = createClassroom();
                boolean rs = classroomDAO.createClass(classroom);
                if(rs) {
                    notice.successAdd();
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
        try {
            Alert alert;
            if (tf_className.getText().isEmpty()) {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Classroom " + tf_className.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    Classroom classroom = createClassroom();
                    boolean result = classroomDAO.updateClassroom(classroom);
                    if(result) {
                        notice.successUpdate();
                        //TO DO UPDATE THE TABLEVIEW
                        addClassroomShowListData();
                        //TO CLEAR THE FIELDS
                        addClassroomClear();
                    }
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

        try {
            Alert alert;
            if (tf_className.getText().isEmpty()) {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Class " + tf_className.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    Classroom creClass = createClassroom();
                    boolean re = classroomDAO.deleteClassroom(creClass);
                    if(re == true) {
                        notice.successDelete();
                        //TO DO UPDATE THE TABLEVIEW
                        addClassroomShowListData();
                        //TO CLEAR THE FIELDS
                        addClassroomClear();
                    }
                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Search Classroom
    public void addClassSearch() {
        FilteredList<Classroom> filter = new FilteredList<>(addClassroomList, e -> true);
        String searchKey = class_search.getText().toLowerCase();

        filter.setPredicate(predicateTeacherData -> {

            if (searchKey == null || searchKey.isEmpty()) {
                return true;
            }
            if (predicateTeacherData.getName().toString().toLowerCase().contains(searchKey)) {
                return true;
            } else if (predicateTeacherData.getTeacherName().toLowerCase().contains(searchKey)) {
                return true;
            } else if (predicateTeacherData.getYear().toLowerCase().contains(searchKey)) {
                return true;
            } else if (predicateTeacherData.getQuality().toString().contains(searchKey)) {
                return true;
            } else if (predicateTeacherData.getRoom().toLowerCase().contains(searchKey)) {
                return true;
            } else {
                return false;
            }
        });
        //SẮP XẾP DANH SÁCH HỌC SINH ĐƯỢC TÌM KIẾM THEO THEO BẢNG CHỮ CÁI A-Z
        SortedList<Classroom> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(class_tableView.comparatorProperty());
        class_tableView.setItems(sortList);
    }

    public void addClassroomTeacherNameList() {
        ObservableList listC = classroomDAO.createTeacherList();
        cb_classTeacherName.setItems(listC);
    }
//YEAR SCHOOL
public boolean validateYear() {
    Alert alert;
    if (tf_year.getText().isEmpty()
            || tf_schoolyear.getText().isEmpty()
            || date_start.getValue() == null
            || date_end.getValue() ==null) {
        notice.errorBlankField();
        return false;
    }
    return true;
}

    public Year createYear() {
        Year year = new Year();
        year.setId(tf_year.getText());
        year.setSchoolYear(tf_schoolyear.getText());
        year.setStartDate(java.sql.Date.valueOf(date_start.getValue()));
        year.setEndDate(java.sql.Date.valueOf(date_end.getValue()));
        return year;
    }

    //Process add button in Year form
    //Add a new year to table
    public void addYearAdd() {
        try {
            Alert alert;
            if (validateYear() == false) return;

            //CHECK STUDENT EXITS?
            if (yearDAO.isYearExist(tf_year.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Year # " + tf_year.getText() + " was already exited!");
                alert.showAndWait();
            } else {
                Year year = createYear();
                boolean result = yearDAO.createNewYear(year);

                if (result == false) {
                    notice.falseAdd();
                }
                else {
                    notice.successAdd();
                    //TO UPDATE THE TABLEVIEW
                    addYearShowListData();
                    //TO CLEAR THE FIELDS
                    addYearClear();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process clear button
    public void addYearClear() {
        tf_year.setText("");
        tf_schoolyear.setText("");
        date_start.setValue(null);
        date_end.setValue(null);
    }

    //Process with update button
    public void addYearUpdate() {
        try {
            Alert alert;
            if (tf_year.getText().isEmpty()) {
                return;
            } else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Year #" + tf_year.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    Year year = createYear();
                    boolean result = yearDAO.updateYear(year);

                    if (result == true) {
                        notice.successUpdate();

                        addYearShowListData();
                        addYearClear();
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Process with delete button
    public void addYearDelete() {
        try {
            Alert alert;
            if (tf_year.getText().isEmpty()) {return;}
            else {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Year #" + tf_year.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    Year year = createYear();
                    boolean result = yearDAO.deleteYear(year);
                    if(result == true) {
                        notice.successDelete();

                        addYearShowListData();
                        addYearClear();
                    }
                } else return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private ObservableList<Year> addYearListD;

    public void addYearShowListData() {
        addYearListD = yearDAO.addYearListData();

        year_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        year_col_schoolYear.setCellValueFactory(new PropertyValueFactory<>("schoolYear"));
        year_col_startDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        year_col_endDate.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        table_yearView.setItems(addYearListD);
    }

    //Khi kích chọn vào hàng trong bảng TableView thì nó sẽ thêm thông tin vào các trường bên dưới (ảnh, tên...)

    public void addYearSelect() {
        Year yearD = table_yearView.getSelectionModel().getSelectedItem();
        int num = table_yearView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        tf_year.setText(String.valueOf(yearD.getId()));
        tf_schoolyear.setText(String.valueOf(yearD.getSchoolYear()));
        date_start.setValue(LocalDate.parse(String.valueOf(yearD.getStartDate())));
        date_end.setValue(LocalDate.parse(String.valueOf(yearD.getEndDate())));
    }
        //Chuyển đổi giữa các form home, student, teacher, class, year
    public void swichForm(ActionEvent event) {
        if (event.getSource() == button_home) {
            home_form.setVisible(true);
            student_form.setVisible(false);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            year_form.setVisible(false);

            button_home.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_year.setStyle("-fx-background-color: transparent");

            homeDisplayTotalStudents();
            homeDisplayTotalTeachers();
            homeDisplayTotalClasses();

        } else if (event.getSource() == button_student) {
            home_form.setVisible(false);
            student_form.setVisible(true);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            year_form.setVisible(false);

            button_student.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_home.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_year.setStyle("-fx-background-color: transparent");

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
            year_form.setVisible(false);

            button_teacher.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_home.setStyle("-fx-background-color: transparent");
            button_class.setStyle("-fx-background-color: transparent");
            button_year.setStyle("-fx-background-color: transparent");
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
            year_form.setVisible(false);

            button_class.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
            button_student.setStyle("-fx-background-color: transparent");
            button_teacher.setStyle("-fx-background-color: transparent");
            button_home.setStyle("-fx-background-color: transparent");
            button_year.setStyle("-fx-background-color: transparent");
            addClassroomShowListData();
            addClassroomTeacherNameList();
            addClassroomYearList();
            addClassSearch();

        } else if (event.getSource() == button_year) {
            home_form.setVisible(false);
            student_form.setVisible(false);
            teacher_form.setVisible(false);
            class_form.setVisible(false);
            year_form.setVisible(true);

            button_year.setStyle("-fx-background-color: linear-gradient(to bottom right, #3f82ae, #26bf7d)");
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

    public void logout(ActionEvent event) {
        try {
            Optional<ButtonType> option = notice.confirmLogout();
            if (option.get().equals(ButtonType.OK)) {
                //Hide your dashboard form
                button_logout.getScene().getWindow().hide();

                //Link to login form
                Helper.changeScence(event, "login.fxml");
            } else return;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        account();
        homeDisplayTotalStudents();
        homeDisplayTotalTeachers();
        homeDisplayTotalClasses();
    }
}
