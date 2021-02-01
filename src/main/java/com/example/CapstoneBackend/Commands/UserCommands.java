package com.example.CapstoneBackend.Commands;

import java.util.Optional;

import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;
import com.example.CapstoneBackend.Repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommands {
    @Autowired
    UserRepository userRepository;

    // Let's get a user by ID
    public UserDTO getUserByID(int id) {

        Optional<UserEntity> userEntity = userRepository.findById(id);
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
        
        return userDTO;
    }

    public boolean createNewUser(UserEntity userentity){
        try{
            userRepository.save(userentity);
        return true; 
        }catch (Exception e){
            return false;
        }
        
    }

}
