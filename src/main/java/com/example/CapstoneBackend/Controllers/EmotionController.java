package com.example.CapstoneBackend.Controllers;

import java.util.List;

import com.example.CapstoneBackend.Commands.EmotionCommands;
import com.example.CapstoneBackend.Commands.UserEmotionsCommands;
import com.example.CapstoneBackend.DTO.EmotionDTO;
import com.example.CapstoneBackend.DTO.UserEmotionsDTO;
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

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/emotion")
public class EmotionController {

    @Autowired
    EmotionCommands emotionCommands;

    @Autowired
    UserEmotionsCommands userEmotionsCommands;
    // create entry
    @RequestMapping(value = "/addEmotion", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody EmotionEntity emotionEntity) {

        try {
            emotionCommands.createEmotionEntry(emotionEntity);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(emotionEntity.getEmotions() + " " + emotionEntity.getUser_id() + " was added.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmotionsForUser", params = { "user_id", "lecture_id" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getByUserID(@RequestParam("user_id") int userID, @RequestParam("lecture_id") int lectureID) {

        try {
            List<EmotionDTO> emotionDTO = emotionCommands.getEmotionsForUser(lectureID, userID);
            return ResponseEntity.status(HttpStatus.OK).body(emotionDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmotionsForUserID", params = { "user_id", "lecture_id" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getForUserID(@RequestParam("user_id") int userID, @RequestParam("lecture_id") int lectureID) {

        try {
            List<UserEmotionsDTO> userEmotionDTO = userEmotionsCommands.getEmotionsForUserID(lectureID, userID);
            return ResponseEntity.status(HttpStatus.OK).body(userEmotionDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmotionsByLecture", params = { "lecture_id" }, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getEmotionsByLecture(@RequestParam("lecture_id") int lectureID) {
        try {
            List<EmotionDTO> emotionsDTO = emotionCommands.getEmotionsByLectureID(lectureID);
            return ResponseEntity.status(HttpStatus.OK).body(emotionsDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/getEmotionsForLecture", params = {"lecture_id"}, method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> getEmotionsForLecture(@RequestParam("lecture_id") int lectureID) {
        try {
            List<UserEmotionsDTO> userEmotionsDTO = userEmotionsCommands.getEmotionsForLecture(lectureID);
            return ResponseEntity.status(HttpStatus.OK).body(userEmotionsDTO);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
