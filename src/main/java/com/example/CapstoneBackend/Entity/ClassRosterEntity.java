package com.example.CapstoneBackend.Entity;

import javax.persistence.*;

import com.opencsv.bean.CsvBindByName;

@Entity
@Table(name = "class_roster")
public class ClassRosterEntity {

    public ClassRosterEntity(){};

    @Id
    @Column(name="id", updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @CsvBindByName
    @Column(name="class_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String classId;

    public String getclassId() {
        return this.classId;
    }

    public void setclassId(String classId) {
        this.classId = classId;
    }

    @CsvBindByName
    @Column(name="user_id")
    private int userId;

    public int getuserId() {
        return this.userId;
    }

    public void setuserId(int userId) {
        this.userId = userId;
    }
}