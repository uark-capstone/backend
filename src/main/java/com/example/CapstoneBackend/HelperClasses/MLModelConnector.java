package com.example.CapstoneBackend.HelperClasses;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;

public class MLModelConnector {
    private String _pythonServerURL = "http://127.0.0.1:5000/";
    private RestTemplate _restTemplate = new RestTemplate();
    

    public void addToRekognitionQueue(HashMap<String, String> data){
        _restTemplate.postForObject(_pythonServerURL + "rekognition-queue", data, String.class);
    }

}
