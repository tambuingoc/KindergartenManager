package com.example.kindergartenmanager;

public class Classroom {
    private String name;
    private Integer quality;
    private String room;
    private String teacherName;
    private String year;

    public Classroom(String name, Integer quality, String room, String teacherName, String year) {
        this.name = name;
        this.quality = quality;
        this.room = room;
        this.teacherName = teacherName;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
