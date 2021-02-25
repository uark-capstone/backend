package com.example.CapstoneBackend.DTO;

import java.sql.Timestamp;

public class EmotionDTO {
    
    int lectureID;
    public int getLecture_id() {
        return this.lectureID;
    }

    public void setLecture_id(int lectureID) {
        this.lectureID = lectureID;
    }

    int userID; 
    public int getUser_id() {
        return this.userID;
    }

    public void setUser_id(int userID) {
        this.userID = userID;
    }

    String emotions;
    public String getEmotions() {
        return this.emotions;
    }

    public void setEmotions(String emotions) {
        this.emotions = emotions;
    }

    double percent;
    public double getPercent() {
        return this.percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    Timestamp timestamp;
    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    // not sure if should be string or timestamp !!
    public void setTimestamp(String timestamp) {
        Timestamp time = Timestamp.valueOf(timestamp);
        this.timestamp = time;
    }

    // Constructors 
    public EmotionDTO() {
        
    }
}
