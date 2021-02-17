package com.example.CapstoneBackend.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PreDestroy;

import com.example.CapstoneBackend.Commands.UserCommands;
import com.example.CapstoneBackend.DTO.AWSDTO;
import com.example.CapstoneBackend.HelperClasses.MLModelConnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/AWS")
public class AWSController {
    @Autowired
    UserCommands userCommands; 

    private ExecutorService _executor = Executors.newSingleThreadExecutor();
    private MLModelConnector _mlConnector = new MLModelConnector();

    @PreDestroy
    public void shutdown() {
        // needed to avoid resource leak
        _executor.shutdown(); 
    }

    //TAKE IN EXTENSION PIC AND RETURN JSON OBJECT CONSUMED BY AWS
    @RequestMapping(value = "/image-from-extension", consumes = { MediaType.APPLICATION_JSON_VALUE,
        MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE }, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> postBody(@RequestBody AWSDTO awsDTO) {
        try {
            HashMap<String, String> map = new HashMap<>();
                map.put("userId", awsDTO.getUserId());
                map.put("lectureId", awsDTO.getLectureId());
                map.put("timestamp", awsDTO.getTs());
                map.put("base64String", awsDTO.getBase64String());
    
            _executor.submit(() -> _mlConnector.addToRekognitionQueue(map));

            return ResponseEntity.status(HttpStatus.OK).body("Picture added to rekognition queue");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }   
}


