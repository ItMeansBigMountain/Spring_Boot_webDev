package com.projectGroup.mySQL_REST.Entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_courses")
public class Course {

    @Id
    @Column(name = "c_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseid;
    private String title;
    private String instructor;


    public Course() {
    }

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
