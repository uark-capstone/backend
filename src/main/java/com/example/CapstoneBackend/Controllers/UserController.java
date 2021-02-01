package com.example.CapstoneBackend.Controllers;

import com.example.CapstoneBackend.Commands.UserCommands;
import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;

import org.springframework.http.*;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    UserCommands userCommands;

    @GetMapping("/get/{id}")
    ResponseEntity<UserDTO> getByID(@PathVariable int id) {
        UserDTO userDTO = userCommands.getUserByID(id);
        return ResponseEntity.status(HttpStatus.SC_OK).body(userDTO);
    }


    // @PostMapping("/get/{id}")
    // ResponseEntity<UserDTO> getByID(@PathVariable int id) {
    //     UserDTO userDTO = userCommands.getUserByID(id);
    //     return ResponseEntity.status(HttpStatus.SC_OK).body(userDTO);
    // }

    @PostMapping(
        value = "/addUser",
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> postBody(@RequestBody UserEntity userEntity) {
        boolean isAddedSuccesful = userCommands.createNewUser(userEntity);
        return ResponseEntity.status(HttpStatus.SC_OK).body(isAddedSuccesful);
    }


}
