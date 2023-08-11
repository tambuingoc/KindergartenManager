package com.example.kindergartenmanager.dao;

import com.example.kindergartenmanager.model.Student;
import com.example.kindergartenmanager.model.Year;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YearDAO extends DAO{
    public YearDAO() {
        super();
    }
    public boolean createNewYear(Year year){
        String sql = "INSERT INTO SchoolYear (id, schoolYear, startDate, endDate) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,  year.getId());
            ps.setString(2, year.getSchoolYear());
            ps.setString(3, year.getStartDate().toString());
            ps.setString(4, year.getEndDate().toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isYearExist(String id){
        String sql = " SELECT id FROM SchoolYear WHERE id = '"
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
    public boolean updateYear(Year year) {
        String updateData = "UPDATE SchoolYear SET id = ?, schoolYear = ?, startDate = ?, endDate = ? WHERE id = ?";

        try{
            PreparedStatement ps = con.prepareStatement(updateData);
            ps.setString(1,  year.getId());
            ps.setString(2, year.getSchoolYear());
            ps.setString(3, year.getStartDate().toString());
            ps.setString(4, year.getEndDate().toString());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteYear(Year year) {
        String deleteData = "DELETE FROM SchoolYear WHERE id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(deleteData);
            preparedStatement.setString(1, year.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ObservableList<Year> addYearListData() {

        ObservableList<Year> listYears = FXCollections.observableArrayList();
        String sql = "SELECT * FROM SchoolYear";

        try {
            Year yearD;
            PreparedStatement prepare = con.prepareStatement(sql);
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                yearD = new Year(result.getString("id"),
                        result.getString("schoolYear"),
                        result.getDate("startDate"),
                        result.getDate("endDate"));

                listYears.add(yearD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listYears;
    }
}
