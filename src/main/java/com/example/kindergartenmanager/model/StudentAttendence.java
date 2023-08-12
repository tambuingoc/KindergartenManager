package com.example.kindergartenmanager.model;

import java.sql.Date;

public class StudentAttendence extends Student{
    private String status;

    public StudentAttendence(String status) {
        this.status = status;
    }

    public StudentAttendence() {
    }

    public StudentAttendence(Integer studentNum, String yearSt, String classNameSt, String nameSt, String genderSt, String addressSt, Date birthSt, String parentNameSt, String phoneSt, String statusSt, String imageSt, String status) {
        super(studentNum, yearSt, classNameSt, nameSt, genderSt, addressSt, birthSt, parentNameSt, phoneSt, statusSt, imageSt);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
