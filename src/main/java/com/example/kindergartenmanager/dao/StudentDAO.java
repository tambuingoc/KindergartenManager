package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;

public class StudentDAO extends DAO {

    public StudentDAO() {
        super();
    }

    public int countTotalStudents() {
        String sql = "SELECT COUNT(student_id) as count FROM Students";
        int countStudent = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                countStudent = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countStudent;
    }

    public int countTotalStudentByTeacher(String teacherName) {
        ObservableList<Student> studentList = getStudentsByTeacherName(teacherName);
        int countStudent = 0;
        for(Student student : studentList) {
            countStudent += 1;
        }
        return countStudent;
    }

    public int countTotalMaleStudents(String teacherName) {
        ObservableList<Student> studentList = getStudentsByTeacherName(teacherName);
        int countMaleStudent = 0;
        for(Student student : studentList) {
            if(student.getGenderSt().strip().equalsIgnoreCase("Nam")) {
                countMaleStudent += 1;
            }
        }
        return countMaleStudent;
    }

    public boolean createStudent(Student student){
        String sql = "INSERT INTO Students (studentNum, yearSt, classNameSt, nameSt, genderSt, addressSt, birthSt, parentNameSt, phoneSt, statusSt, imageSt) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,  student.getStudentNum().toString());
            ps.setString(2, (String) student.getYearSt());
            ps.setString(3, (String) student.getClassNameSt());
            ps.setString(4, student.getNameSt());
            ps.setString(5, (String) student.getGenderSt());
            ps.setString(6, student.getAddressSt());
            ps.setString(7, student.getBirthSt().toString());
            ps.setString(8, student.getParentNameSt());
            ps.setString(9, student.getPhoneSt());
            ps.setString(10, (String) student.getStatusSt());
            ps.setString(11, student.getImageSt());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isStudentExist(String id){
        String sql = " SELECT studentNum FROM Students WHERE studentNum = '"
                + id +"'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;}
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList createClassList() {
        ObservableList listC = FXCollections.observableArrayList();
        String listClass = "SELECT * from Classrooms";

        try {

            PreparedStatement prepare = con.prepareStatement(listClass);
            ResultSet result = prepare.executeQuery();

            while (result.next()) {
                listC.add(result.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listC;
    }
    public boolean updateStudent(Student student) {
        String updateData = "UPDATE Students SET yearSt = ?, classNameSt = ?, nameSt = ?, genderSt = ?, addressSt = ?, birthSt = ?, parentNameSt = ?, phoneSt = ?, statusSt = ?, imageSt = ? WHERE studentNum = ?";

        try{
            PreparedStatement preparedStatement = con.prepareStatement(updateData);
            preparedStatement.setString(1, student.getYearSt().toString());
            preparedStatement.setString(2, student.getClassNameSt());
            preparedStatement.setString(3, student.getNameSt());
            preparedStatement.setString(4, student.getGenderSt());
            preparedStatement.setString(5, student.getAddressSt());
            preparedStatement.setString(6, student.getBirthSt().toString());
            preparedStatement.setString(7, student.getParentNameSt());
            preparedStatement.setString(8, student.getPhoneSt());
            preparedStatement.setString(9, student.getStatusSt());
            preparedStatement.setString(10, student.getImageSt());
            preparedStatement.setString(11, student.getStudentNum().toString());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(Student student) {
        String deleteData = "DELETE FROM Students WHERE studentNum = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(deleteData);
            preparedStatement.setInt(1, student.getStudentNum());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //Return list student of all Classroom
    public ObservableList<Student> addStudentListData() {

        ObservableList<Student> listStudents = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Students";

        try {
            Student studentD;
            PreparedStatement prepare = con.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
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

    public ObservableList<Student> searchStudentByName(String name) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Students WHERE studentNum LIKE ?";
        try (PreparedStatement ps = DAO.con.prepareStatement(sql)) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // create a Student object from the result set and add it to the list
                    Student student = new Student();
                    student.setStudentNum(rs.getInt("studentNum"));
                    student.setYearSt(rs.getString("yearSt"));
                    student.setClassNameSt(rs.getString("classNameSt"));
                    student.setNameSt(rs.getString("nameSt"));
                    student.setGenderSt(rs.getString("genderSt"));
                    student.setAddressSt(rs.getString("addressSt"));
                    student.setBirthSt(rs.getDate("birthSt"));
                    student.setParentNameSt(rs.getString("parentNameSt"));
                    student.setPhoneSt(rs.getString("phoneSt"));
                    student.setStatusSt(rs.getString("statusSt"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    //Return list students by teacherName
    public ObservableList<Student> getStudentsByTeacherName(String teacherName) {
        ObservableList<Student> students = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Students AS s JOIN Classrooms AS c ON s.classNameSt = c.name WHERE c.teacherName LIKE ?";
        try (PreparedStatement ps = DAO.con.prepareStatement(sql)) {
            ps.setString(1, "%" + teacherName + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // create a Student object from the result set and add it to the list
                    Student student = new Student();
                    student.setStudentNum(rs.getInt("studentNum"));
                    student.setYearSt(rs.getString("yearSt"));
                    student.setClassNameSt(rs.getString("classNameSt"));
                    student.setNameSt(rs.getString("nameSt"));
                    student.setGenderSt(rs.getString("genderSt"));
                    student.setAddressSt(rs.getString("addressSt"));
                    student.setBirthSt(rs.getDate("birthSt"));
                    student.setParentNameSt(rs.getString("parentNameSt"));
                    student.setPhoneSt(rs.getString("phoneSt"));
                    student.setStatusSt(rs.getString("statusSt"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

