package com.example.kindergartenmanager;

import java.sql.Date;

//Student database (Model)
public class Student {
    private Integer studentNum;
    private String yearSt;
    private String classNameSt;
    private String nameSt;
    private String genderSt;
    private String addressSt;
    private Date birthSt;
    private String parentNameSt;
    private String phoneSt;
    private String statusSt;
    private String imageSt;

    public Student(Integer studentNum, String yearSt, String classNameSt, String nameSt, String genderSt, String addressSt, Date birthSt, String parentNameSt, String phoneSt, String statusSt, String imageSt) {
        this.studentNum = studentNum;
        this.yearSt = yearSt;
        this.classNameSt = classNameSt;
        this.nameSt = nameSt;
        this.genderSt = genderSt;
        this.addressSt = addressSt;
        this.birthSt = birthSt;
        this.parentNameSt = parentNameSt;
        this.phoneSt = phoneSt;
        this.statusSt = statusSt;
        this.imageSt = imageSt;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getYearSt() {
        return yearSt;
    }

    public void setYearSt(String yearSt) {
        this.yearSt = yearSt;
    }

    public String getClassNameSt() {
        return classNameSt;
    }

    public void setClassNameSt(String classNameSt) {
        this.classNameSt = classNameSt;
    }

    public String getNameSt() {
        return nameSt;
    }

    public void setNameSt(String nameSt) {
        this.nameSt = nameSt;
    }

    public String getGenderSt() {
        return genderSt;
    }

    public void setGenderSt(String genderSt) {
        this.genderSt = genderSt;
    }

    public String getAddressSt() {
        return addressSt;
    }

    public void setAddressSt(String addressSt) {
        this.addressSt = addressSt;
    }

    public Date getBirthSt() {
        return birthSt;
    }

    public void setBirthSt(Date birthSt) {
        this.birthSt = birthSt;
    }

    public String getParentNameSt() {
        return parentNameSt;
    }

    public void setParentNameSt(String parentNameSt) {
        this.parentNameSt = parentNameSt;
    }

    public String getPhoneSt() {
        return phoneSt;
    }

    public void setPhoneSt(String phoneSt) {
        this.phoneSt = phoneSt;
    }

    public String getStatusSt() {
        return statusSt;
    }

    public void setStatusSt(String statusSt) {
        this.statusSt = statusSt;
    }

    public String getImageSt() {
        return imageSt;
    }

    public void setImageSt(String imageSt) {
        this.imageSt = imageSt;
    }
}
