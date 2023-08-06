package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Classroom;
import com.example.kindergartenmanager.model.Student;
import com.example.kindergartenmanager.model.Teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean updateTeacher(Teacher teacher) {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE Teachers SET "
                + "name = '" + teacher.getName()
                + "', gender = '" + teacher.getGender()
                + "', address = '" + teacher.getAddress()
                + "', phone = '" + teacher.getPhone()
                + "', dob = '" + teacher.getDob()
                + "', cardID = '" + teacher.getCardID()
                + "', degree = '" + teacher.getDegree()
                + "', className = '" + teacher.getClassName()
                + "', salary = '" + teacher.getSalary()
                + "', image = '" + uri + "' WHERE teacherNum = '"
                + teacher.getTeacherNum() + "'";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTeacher(Teacher teacher) {
        String sql = "DELETE FROM Teachers WHERE teacherNum = '"
                + teacher.getTeacherNum() + "'";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


