package com.example.CapstoneBackend.DTO;

import java.sql.Timestamp;

public class LectureDTO {
    
    int id;
    int classID;
    String lectureName;
    Timestamp lectureStartTime;
    Timestamp lectureEndTime;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassID() {
        return this.classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getLectureName() {
        return this.lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public Timestamp getLectureStartTime() {
        return this.lectureStartTime;
    }

    public void setLectureStartTime(Timestamp lectureStartTime) {
        this.lectureStartTime = lectureStartTime;
    }

    public Timestamp getLectureEndTime() {
        return this.lectureEndTime;
    }

    public void setLectureEndTime(Timestamp lectureEndTime) {
        this.lectureEndTime = lectureEndTime;
    }

}
