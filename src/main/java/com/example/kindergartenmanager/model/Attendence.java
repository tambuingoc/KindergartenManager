package com.example.kindergartenmanager.model;

import java.util.Date;
import java.util.List;

public class Attendence {
    private Date time;
    private Integer student_id;
    private String status;

    public Attendence() {
    }

    public Attendence(Date time, Integer student_id, String status) {
        this.time = time;
        this.student_id = student_id;
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
