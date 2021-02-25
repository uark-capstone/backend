package com.example.CapstoneBackend.Entity;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="lectures")
public class LectureEntity {

    public LectureEntity(){};

    @Id
    @Column(name="id", updatable = false) 
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id = 0;
    public int getId() {
        return this.id;
    }

    @Column(name = "class_id")
    private int classID;

    public int getClass_id() {
        return this.classID;
    }

    public void setClass_id(int classID) {
        this.classID = classID;
    }

    @Column(name = "lecture_name")
    private String lectureName;

    public String getLectureName() {
        return this.lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    @Column(name = "lecture_start_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp lectureStartTime;
    
    public Timestamp getLectureStartTime(){
        return this.lectureStartTime;
    }

    public void setLectureStartTime(String lectureStartTime) {

        Timestamp timestamp = Timestamp.valueOf(lectureStartTime);
        this.lectureStartTime = timestamp;
        // this.lectureStartTime = timeStamp;
    }

    @Column(name = "lecture_end_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp lectureEndTime;

    public Timestamp getLectureEndTime() {
        return this.lectureEndTime;
    }

    public void setLectureEndTime(Timestamp lectureEndTime) {
        this.lectureEndTime = lectureEndTime;
    }

}

