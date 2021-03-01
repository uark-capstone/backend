package com.example.CapstoneBackend.DTO;

import java.sql.Timestamp;

public class UserEmotionsDTO {

    private int userID;
    private String emotions;
    private double percent;
    private Timestamp timestamp;
    private String name;

    public int getUserID() {
        return this.userID;
    }

    public String getEmotions() {
        return this.emotions;
    }

    public double getPercent() {
        return this.percent;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public String getName() {
        return this.name;
    }

    public UserEmotionsDTO(int userID, String emotions, double percent, Timestamp timestamp, String name) {
        this.userID = userID;
        this.emotions = emotions;
        this.percent = percent;
        this.timestamp = timestamp;
        this.name = name;
    }
    
}
