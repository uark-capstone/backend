package com.example.CapstoneBackend.Commands;

import java.util.Optional;

import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;
import com.example.CapstoneBackend.HelperClasses.CustomExceptions;

import com.example.CapstoneBackend.Repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserCommands holds all the functions that apply to the UserEntity class
 */
@Service
public class UserCommands {
    @Autowired // autowire allows us to automatically create a UserRepository instance and use
               // it anywhere
    UserRepository userRepository;

    // CREATING A NEW USER
    public void createNewUser(UserEntity paramUserEntity) {
        Optional<UserEntity> userEntity = userRepository.findByemail(paramUserEntity.getEmail());
        if (!userEntity.isPresent()) {
            userRepository.save(paramUserEntity);
        } else {
            throw new CustomExceptions.CreationException("User");
        }

    }

    // Create user from csv
    public void createNewCSVUser(UserEntity paramUserEntity) {
        Optional<UserEntity> userEntity = userRepository.findByemail(paramUserEntity.getEmail());
        if(!userEntity.isPresent()) {
            userRepository.save(paramUserEntity);
        } else {
            throw new CustomExceptions.CreationException("User");
        }
    }

    // GETTING USER BY ID
    public UserDTO getUserByID(int id) {
        UserDTO userDTO = new UserDTO();
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (!userEntity.isPresent()) {
            throw new CustomExceptions.NotFoundException("User");
        }

        // ModelMapper allows us to automatically map our entity to a DTO class, instead
        // of
        // doing userDTO.setName(entity.getName()) on every single variable

        ModelMapper modelMapper = new ModelMapper();
        userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
        return userDTO;
    }

    // GETTING USER BY EMAIL
    public UserDTO getUserbyEmail(String email) {
        UserDTO userDTO = new UserDTO();
        Optional<UserEntity> userEntity = userRepository.findByemail(email);
        if (!userEntity.isPresent()) {
            throw new CustomExceptions.NotFoundException("User");
        }

        ModelMapper modelMapper = new ModelMapper();
        userDTO = modelMapper.map(userEntity.get(), UserDTO.class);
        return userDTO;
    }

    // UPDATE FIELDS ON A USER

    // DELETE USER VIA EMAIL
    public void deleteUser(String email) {
        Optional<UserEntity> userEntity = userRepository.findByemail(email);
        if (userEntity.isPresent()) {
            userRepository.delete(userEntity.get());
        } else {
            throw new CustomExceptions.NoDeleteException("Users");
        }
    }

    // DELETE ALL USERS FROM DB
    public void deleteEveryone() {
        try {
            userRepository.deleteAll();
        } catch (Exception e) {
            throw new CustomExceptions.NoDeleteException("Users");
        }

    }

    // LOGGING IN A USER
    public void loginUser(UserEntity paramUserEntity) {

        Optional<UserEntity> userEntity = userRepository.findByemail(paramUserEntity.getEmail());

        try {
            if (userEntity.isPresent()) {
                if (paramUserEntity.getPassword().equals(userEntity.get().getPassword())) {
                    userEntity.get().setIsLoggedIn(true);
                    userRepository.save(userEntity.get());
                } else {
                    throw new CustomExceptions.IncorrectLoginException();
                }
            }
        } catch (Exception e) {
            throw new CustomExceptions.NotFoundException("User");
        }
    }

    // LOGGING IN A USER
    public void loggingOut(UserEntity paramUserEntity) {

        Optional<UserEntity> userEntity = userRepository.findByemail(paramUserEntity.getEmail());

        try {
            if (userEntity.isPresent()) {
                userEntity.get().setIsLoggedIn(false);
                userRepository.save(userEntity.get());
            }
        } catch (Exception e) {
            throw new CustomExceptions.LoggingOutException();
        }
    }

}
