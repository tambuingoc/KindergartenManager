package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Attendence;
import com.example.kindergartenmanager.model.StudentAttendence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendenceDAO extends DAO{
    public AttendenceDAO() {
        super();
    }

    public boolean saveStatus(Attendence attendence) {
        String sql = "INSERT INTO Attendence (time, status, studentNum) VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, attendence.getTime().toString());
            ps.setString(2, attendence.getStatus());
            ps.setString(3, attendence.getStudent_id().toString());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList<StudentAttendence> getStudentsByAttendence(Date dateAttendence, String nameTeacher) {
        ObservableList<StudentAttendence> students = FXCollections.observableArrayList();
        String sql = "select * from Attendence as a join Students as s on a.studentNum = s.studentNum join Classrooms as c on s.classNameSt = c.name where time = ? and c.teacherName = ?";
        try (PreparedStatement ps = DAO.con.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(dateAttendence));
            ps.setString(2, nameTeacher);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // create a Student object from the result set and add it to the list
                    StudentAttendence student = new StudentAttendence();
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
                    student.setStatus(rs.getString("status"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
