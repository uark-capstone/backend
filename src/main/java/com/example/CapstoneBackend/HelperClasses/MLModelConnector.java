package com.example.CapstoneBackend.HelperClasses;

import java.util.HashMap;

import org.springframework.web.client.RestTemplate;

public class MLModelConnector {
    private String _pythonServerURL = "http://127.0.0.1:5000/";
    private RestTemplate _restTemplate = new RestTemplate();
    

    public void addToRekognitionQueue(HashMap<String, String> data){
        try{
            _restTemplate.postForObject(_pythonServerURL + "rekognition-queue", data, String.class);
        }catch (Exception e){
            System.out.println("Failed to send data to RekognitionQueue");
        }
    }

}
