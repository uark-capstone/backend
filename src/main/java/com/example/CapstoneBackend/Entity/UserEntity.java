package com.example.CapstoneBackend.Entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    public UserEntity(){}; 
     
    @Id
    @Column(name="id",  updatable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int id = 0;
    public int getId() {
        return this.id;
    }

    @Column(name = "classification")
    private int classification;

    public int getClassification() {
        return this.classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    @Column(name = "name")
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email")
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Will probably need to add more constructors here as we start to implement
     * more business logic. But for now an empty constructor works cause that's what
     * Springboot needs to do mapping 
     */


    // public UserEntity(){}; 

}

