package com.genSpark.Spring_Boot_Template.Entity;

public class Course {

    private int courseid;
    private String title;
    private String instructor;


    public Course(int courseid, String title, String instructor) {
        this.courseid = courseid;
        this.title = title;
        this.instructor = instructor;
    }


    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }


}
