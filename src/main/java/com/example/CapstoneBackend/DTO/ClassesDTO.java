package com.example.CapstoneBackend.DTO;

public class ClassesDTO {

    int professorid;

    public int getprofessorId() {
        return this.professorid;
    }

    public void setprofessorId(int professorid) {
        this.professorid = professorid;
    }

    String courseName;

    public String getcourseName() {
        return this.courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    int studentCount;

    public int getstudentCount() {
        return this.studentCount;
    }

    public void setstudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    // Constructors
    public ClassesDTO() {
    }

}
