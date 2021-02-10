package com.example.CapstoneBackend.Controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import com.example.CapstoneBackend.Commands.UserCommands;
import com.example.CapstoneBackend.DTO.AWSDTO;
import com.example.CapstoneBackend.DTO.UserDTO;
import com.example.CapstoneBackend.Entity.UserEntity;
import com.example.CapstoneBackend.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@RestController
@RequestMapping(value = "/AWS")
public class AWSController {
    @Autowired
    UserCommands userCommands; 

    //TAKE IN EXTENSION PIC AND RETURN JSON OBJECT CONSUMED BY AWS
    @RequestMapping(value = "/image-from-extension", consumes = { MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)

    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody AWSDTO awsDTO) {

        try {
            final String uri = "http://127.0.0.1:5000/rekognition";
            RestTemplate restTemplate = new RestTemplate();
    
            HashMap<String, String> map = new HashMap<>();
                map.put("base64String", awsDTO.getBase64String());
    
            String awsResult = restTemplate.postForObject(uri, map, String.class);

            // UserDTO userDTO= userCommands.getUserbyEmail(awsDTO.getID());
            // awsDTO.setID(String.valueOf(userDTO.getId()));
            // System.out.println(awsDTO.toString());
            
            return ResponseEntity.status(HttpStatus.OK).body(awsResult);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }   
}
