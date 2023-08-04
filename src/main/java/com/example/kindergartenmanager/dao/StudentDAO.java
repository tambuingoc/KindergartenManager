package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO extends DAO {

    public StudentDAO() {
        super();
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


}
