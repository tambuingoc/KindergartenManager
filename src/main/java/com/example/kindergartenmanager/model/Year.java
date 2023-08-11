package com.example.kindergartenmanager.model;

import java.util.Date;

public class Year {
    private String id;
    private String schoolYear;
    private Date startDate;
    private Date endDate;

    public Year() {
    }

    public Year(String id, String schoolYear, Date startDate, Date endDate) {
        this.id = id;
        this.schoolYear = schoolYear;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
