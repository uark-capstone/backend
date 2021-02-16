package com.example.CapstoneBackend.DTO;


public class AWSDTO {
    String userId;
    String lectureId;
    String ts; 
    String base64String; 

    public AWSDTO(){};

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", lectureId='" + getLectureId() + "'" +
            ", ts='" + getTs() + "'" +
            ", base64String='" + getBase64String() + "'" +
            "}";
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLectureId() {
        return this.lectureId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public String getTs() {
        return this.ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getBase64String() {
        return this.base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
    
}