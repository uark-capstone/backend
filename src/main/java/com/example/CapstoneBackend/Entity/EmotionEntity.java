package com.example.CapstoneBackend.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity 
@Table(name = "emotions")
public class EmotionEntity {

    public EmotionEntity(){};

    @Id
    @Column(name="id", updatable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    public int id = 0;
    
    public int getId() {
        return this.id;
    }

    @Column(name="lecture_id")
    private int lectureID;

    public int getLecture_id() {
        return this.lectureID;
    }

    public void setLecture_id(int lectureID) {
        this.lectureID = lectureID;
    }

    @Column(name="user_id")
    private int userID;

    public int getUser_id(){
        return this.userID;
    }

    public void setUser_id(int userID) {
        this.userID = userID;
    }

    @Column(name="emotions")
    private String emotions;

    public String getEmotions(){
        return this.emotions;
    }

    public void setEmotions(String emotions) {
        this.emotions = emotions;
    }

    @Column(name="percent")
    private double percent;

    public double getPercent(){
        return this.percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Column(name="timestamp")
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}