package com.example.CapstoneBackend.Controllers;

import com.example.CapstoneBackend.Commands.UserCommands;
import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that hosts all endpoints related to: USERS
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserCommands userCommands;

    // We can pass the UserEntity as a param because Springboot maps the values of
    // the json to
    // fields in the UserEntity class

    // CREATE USER
    @RequestMapping(value = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody UserEntity userEntity) {
        
        try {
            userCommands.createNewUser(userEntity);
            return ResponseEntity.status(HttpStatus.OK).body(userEntity.getName()+ " was added!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    // GETS USER BY ID
    @RequestMapping(value = "/getUserByID", params = { "id" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByID(@RequestParam("id") int id) {

        try {
            UserDTO userDTO = userCommands.getUserByID(id);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // GETS USER BY EMIAIL
    @RequestMapping(value = "/getUserByEmail", params = { "email" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByEmail(@RequestParam("email") String email) {

        try {
            UserDTO userDTO = userCommands.getUserbyEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // DELETE USER VIA EMAIL
    @RequestMapping(value = "/deleteUserByEmail", params = { "email" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteUser(@RequestParam("email") String email) {
        try{
            userCommands.deleteUser(email); 
            return ResponseEntity.status(HttpStatus.OK).body("User tied to "+email+" has been deleted.");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //DELETE EVERYONE FROM DB
    @RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> deleteAll() {

        try {
            userCommands.deleteEveryone();
            return ResponseEntity.status(HttpStatus.OK).body("All users are deleted!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
