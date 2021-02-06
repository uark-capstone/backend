package com.example.CapstoneBackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "class_roster")
public class ClassRosterEntity {

    public ClassRosterEntity(){};

    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id = 0;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="class_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String classId = "";

    public String getclassId() {
        return this.classId;
    }

    public void setclassId(String classId) {
        this.classId = classId;
    }

    @Column(name="user_id")
    private int userId;

    public int getuserId() {
        return this.userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }
}