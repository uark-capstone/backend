package com.example.CapstoneBackend.Controllers;

import org.springframework.http.*;
import org.springframework.http.HttpStatus;

import com.example.CapstoneBackend.Commands.LectureCommands;
import com.example.CapstoneBackend.Entity.LectureEntity;

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
@RequestMapping(value = "/lecture")
public class LectureController {
    
    @Autowired
    LectureCommands lectureCommands;

    @RequestMapping(value = "/addLecture", consumes = {MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> postBody(@RequestBody LectureEntity lectureEntity) {
        try {
            lectureCommands.createNewLecture(lectureEntity);
            return ResponseEntity.status(HttpStatus.OK).body(lectureEntity.getLectureName()+ " was added.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
