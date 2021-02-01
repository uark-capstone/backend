package com.example.CapstoneBackend.Commands;

import java.util.Optional;

import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;

import com.example.CapstoneBackend.HelperClasses.NotFoundException;
import com.example.CapstoneBackend.Repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserCommands holds all the functions that apply to the UserEntity class
 */
@Service
public class UserCommands {
    @Autowired //autowire allows us to automatically create a UserRepository instance and use it anywhere
    UserRepository userRepository;


    // Let's get a user by ID
    public UserDTO getUserByID(int id) {
        UserDTO userDTO= new UserDTO(); 
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(!userEntity.isPresent()){
             throw new NotFoundException("User"); 
        }
       
        //ModelMapper allows us to automatically map our entity to a DTO class, instead of 
        //doing userDTO.setName(entity.getName()) on every single variable

        ModelMapper modelMapper = new ModelMapper();
        userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
        return userDTO; 
    }

    public boolean createNewUser(UserEntity userEntity){
        try{
            //will prob wanna do error checking here to see if the user exists
            userRepository.save(userEntity);
        return true; 
        }catch (Exception e){
            return false;
        }
        
    }

}
