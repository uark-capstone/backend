package com.example.CapstoneBackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "classes")
public class ClassesEntity {

    public ClassesEntity(){}; 
     
    @Id
    @Column(name="id",  updatable = false)
    public String id = "";
    public String getId() {
        return this.id;
    }

    @Column(name = "professor_id")
    private int professorid;

    public int getprofessorid() {
        return this.professorid;
    }

    public void setprofessordid(int professorid) {
        this.professorid = professorid;
    }

    @Column(name = "course_name")
    private String courseName;

    public String getcourseName() {
        return this.courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "student_count")
    private int studentCount;

    public int getstudentCount() {
        return this.studentCount;
    }

    public void setstudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    @Column(name = "password")
    private String password;

    /**
     * Will probably need to add more constructors here as we start to implement
     * more business logic. But for now an empty constructor works cause that's what
     * Springboot needs to do mapping 
     */


    // public UserEntity(){}; 

}

