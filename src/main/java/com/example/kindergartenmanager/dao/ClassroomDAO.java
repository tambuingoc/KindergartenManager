package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Classroom;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassroomDAO extends DAO{
    public ClassroomDAO(){super();}

    public int countClassrooms() {
        String sql = "SELECT COUNT(class_id) as count FROM Classrooms";
        int countClass = 0;
        try {
            PreparedStatement prepare = con.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            if(result.next()) {
                countClass = result.getInt("count");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return countClass;
    }

    public boolean isClassroomExist(String name) {
        String sql = " SELECT name FROM Classrooms WHERE name = '"
                + name + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean createClass(Classroom classroom) {
        String sql = "INSERT INTO Classrooms (name, quality, room, teacherName, year) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, classroom.getName());
            ps.setString(2, classroom.getQuality().toString());
            ps.setString(3, classroom.getRoom());
            ps.setString(4, (String) classroom.getTeacherName());
            ps.setString(5, (String) classroom.getYear());

            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateClassroom(Classroom classroom) {

        String updateData = "UPDATE Classrooms SET "
                + "name = '" + classroom.getName()
                + "', quality = '" + classroom.getQuality()
                + "', room = '" + classroom.getRoom()
                + "', teacherName = '" + classroom.getTeacherName()
                + "', year = '" + classroom.getYear()
                + "'";
        try {
            Statement statement = con.createStatement();
            statement.executeUpdate(updateData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteClassroom(Classroom classroom) {
        String deleteData = "DELETE FROM Classrooms WHERE name = '"
                + classroom.getName() + "'";
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
