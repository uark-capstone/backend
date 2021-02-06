package com.example.CapstoneBackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "class_roster")
public class ClassRosterEntity {

    public ClassRosterEntity(){};

    @Id
    @Column(name="class_id", updatable = false)
    public String class_id = "";
    public String getclass_id() {
        return this.class_id;
    }

    @Column(name="user_id", updatable = false)
    private int user_id;

    public int getuser_id() {
        return this.user_id;
    }
}