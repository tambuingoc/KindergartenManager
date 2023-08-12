package com.example.kindergartenmanager.model;

import java.sql.Date;

public class Teacher {
    private Integer teacherNum;
    private String name;
    private String gender;
    private String address;
    private String phone;
    private Date dob;
    private String cardID;
    private String degree;
    private String className;
    private Float salary;
    private String image;
    private String username;
    private String password;

    public Teacher() {}

    public Teacher(Integer teacherNum, String name, String gender, String address, String phone, Date dob, String cardID, String degree, String className, Float salary, String image, String username, String password) {
        this.teacherNum = teacherNum;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.dob = dob;
        this.cardID = cardID;
        this.degree = degree;
        this.className = className;
        this.salary = salary;
        this.image = image;
        this.username = username;
        this.password = password;
    }

    public Integer getTeacherNum() {
        return teacherNum;
    }

    public void setTeacherNum(Integer teacherNum) {
        this.teacherNum = teacherNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
