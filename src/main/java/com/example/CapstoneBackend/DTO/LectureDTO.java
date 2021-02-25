package com.example.CapstoneBackend.DTO;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    // this is not working
    public void setLectureStartTime(String lectureStartTime) {
        // try {
        //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //     Date parsedDate = dateFormat.parse(lectureStartTime);
        //     Timestamp timestamp = new Timestamp(parsedDate.getTime());
        //     this.lectureStartTime = timestamp;
        // } catch(Exception e) { 
        //     // look the origin of excption 
        // }
        Timestamp timestamp = Timestamp.valueOf(lectureStartTime);
        this.lectureStartTime = timestamp;
        // this.lectureStartTime = lectureStartTime;
    }

    public Timestamp getLectureEndTime() {
        return this.lectureEndTime;
    }

    public void setLectureEndTime(Timestamp lectureEndTime) {
        this.lectureEndTime = lectureEndTime;
    }

}
