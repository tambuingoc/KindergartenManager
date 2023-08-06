package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE Students SET "
                + "yearSt = '" + student.getYearSt()
                + "', classNameSt = '" + student.getClassNameSt()
                + "', nameSt = '" + student.getNameSt()
                + "', genderSt = '" + student.getGenderSt()
                + "', addressSt = '" + student.getAddressSt()
                + "', birthSt = '" + student.getBirthSt()
                + "', parentNameSt = '" +student.getParentNameSt()
                + "', phoneSt = '" + student.getPhoneSt()
                + "', statusSt = '" + student.getStatusSt()
                + "', imageSt = '" + uri + "' WHERE studentNum = '"
                + student.getStudentNum() + "'";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(updateData);
            return true;
        } catch (Exception e) {
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

