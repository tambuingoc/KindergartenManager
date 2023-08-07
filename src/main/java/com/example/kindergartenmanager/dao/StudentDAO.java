package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

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

    public int countTotalStudentsLa2() {
        String sql = "SELECT COUNT(student_id) as count FROM Students WHERE classNameSt = 'Lá 2'";
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

    public int countTotalMaleStudents() {
        String sql = "SELECT COUNT(student_id) as count FROM Students WHERE genderSt = 'Nam' AND classNameSt = 'Lá 2'";
        int countMaleStudnet = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                countMaleStudnet = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countMaleStudnet;
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
            ps.setString(9, student.getParentNameSt());
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
        String deleteData = "DELETE FROM Students WHERE studentNum = '"
                + student.getStudentNum() + "'";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(deleteData);
            return true;
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

    //Return list Student of className = Lá 2
    public ObservableList<Student> addStudentListDataLa2() {

        ObservableList<Student> listStudents = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Students WHERE classNameSt = 'Lá 2'";

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

}

