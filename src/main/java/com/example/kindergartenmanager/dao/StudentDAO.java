package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;

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

    public int countTotalFemaleStudents() {
        String sql = "SELECT COUNT(student_id) as count FROM Students WHERE genderSt = 'Nữ";
        int countFemaleStudent = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                countFemaleStudent = rs.getInt("count");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countFemaleStudent;
    }

    public int countTotalMaleStudents() {
        String sql = "SELECT COUNT(student_id) as count FROM Students WHERE genderSt = 'Nam";
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

}

