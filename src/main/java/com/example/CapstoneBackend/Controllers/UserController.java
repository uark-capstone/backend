package com.example.CapstoneBackend.Controllers;

import javax.swing.tree.ExpandVetoException;

import com.example.CapstoneBackend.Commands.UserCommands;
import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;


import org.springframework.http.*;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * Controller that hosts all endpoints related to: USERS
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserCommands userCommands;

    @GetMapping("/get/{id}")
    ResponseEntity<Object> getByID(@PathVariable int id) {
       
        try{
            UserDTO userDTO = userCommands.getUserByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //We can pass the UserEntity as a param because Springboot maps the values of the json to
    //fields in the UserEntity class
    @PostMapping(
        value = "/addUser",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> postBody(@RequestBody UserEntity userEntity) {
        boolean isAddedSuccesful = userCommands.createNewUser(userEntity);
        try{
        return ResponseEntity.status(HttpStatus.OK).body(isAddedSuccesful);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(isAddedSuccesful);
        }

    }


}
