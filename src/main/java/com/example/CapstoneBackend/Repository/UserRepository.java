package com.example.CapstoneBackend.Repository;

import java.util.Optional;

import com.example.CapstoneBackend.Entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByName(String name); 

    //The classics are already apart of this such as: findbyid, save, delete etc
    //only put functions here that are specific to our code such as searching on a specific
    //variable
    
}