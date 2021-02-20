package com.example.CapstoneBackend.Controllers;

import com.example.CapstoneBackend.Commands.EmotionCommands;
import com.example.CapstoneBackend.DTO.EmotionDTO;
import com.example.CapstoneBackend.Entity.EmotionEntity;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge=3600)
@RestController
@RequestMapping(value = "/emotion")
public class EmotionController {
    
    @Autowired
    EmotionCommands emotionCommands;

    // create entry
    @RequestMapping(value = "/addEmotion", consumes = { MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody EmotionEntity emotionEntity) {
        
        try {
            emotionCommands.createEmotionEntry(emotionEntity);
            return ResponseEntity.status(HttpStatus.OK).body(emotionEntity.getEmotions() + " " +
                                                        emotionEntity.getUser_id() + " was added.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // get emotion by user id - this does not work
    @RequestMapping(value = "/getEmotionByUserID", params = {"user_id"}, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByUserID(@RequestParam("user_id") int userID) {

        try {
            EmotionDTO emotionDTO = emotionCommands.getEmotionByUserID(userID);
            return ResponseEntity.status(HttpStatus.OK).body(emotionDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}