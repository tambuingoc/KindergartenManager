package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Classroom;
import com.example.kindergartenmanager.model.Student;
import com.example.kindergartenmanager.model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherDAO extends DAO {
    public TeacherDAO() {
        super();
    }

    public int countTotalTeachers() {
        String sql = "SELECT COUNT(teacher_id) as count FROM Teachers";
        int countTeacher = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                countTeacher = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countTeacher;
    }

    public boolean createTeacher(Teacher teacher) {
        String sql = "INSERT INTO Teachers (teacherNum, name, gender, address, phone, dob, cardID, degree, className, salary, image) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, teacher.getTeacherNum().toString());
            ps.setString(2, teacher.getName());
            ps.setString(3, (String) teacher.getGender());
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setString(6, teacher.getDob().toString());
            ps.setString(7, teacher.getCardID());
            ps.setString(8, (String) teacher.getDegree());
            ps.setString(9, (String) teacher.getClassName());
            ps.setString(10, teacher.getSalary().toString());
            ps.setString(11, teacher.getImage());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isTeacherExist(String id) {
        String sql = " SELECT teacherNum FROM Teachers WHERE teacherNum = '"
                + id + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //create list class
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

    public boolean updateTeacher(Teacher teacher) {
        String sql = "UPDATE Teachers SET name = ?, gender = ?, address = ?, phone = ?, dob = ?, cardID = ?, degree = ?, className = ?, salary = ?, image = ? WHERE teacherNum = ?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getGender());
            preparedStatement.setString(3, teacher.getAddress());
            preparedStatement.setString(4, teacher.getPhone());
            preparedStatement.setString(5, teacher.getDob().toString());
            preparedStatement.setString(6, teacher.getCardID());
            preparedStatement.setString(7, teacher.getDegree());
            preparedStatement.setString(8, teacher.getClassName());
            preparedStatement.setDouble(9, teacher.getSalary());
            preparedStatement.setString(10, teacher.getImage()); // Assuming getData.path has the correct URI value.
            preparedStatement.setInt(11, teacher.getTeacherNum());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTeacher(Teacher teacher) {
        String sql = "DELETE FROM Teachers WHERE teacherNum = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,teacher.getTeacherNum());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Return list of all teacher
    public ObservableList<Teacher> addTeacherListData() {

        ObservableList<Teacher> listTeachers = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Teachers";

        try {
            Teacher teacherD;
            PreparedStatement prepare = con.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
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
}


