package com.example.CapstoneBackend.HelperClasses;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.client.RestTemplate;

public class MLModelConnector {
    private String _livePythonServerURL = System.getenv("ML_URL");
    private String _pythonServerURL = (_livePythonServerURL != null) ? _livePythonServerURL : "http://127.0.0.1:5000/";

    private RestTemplate _restTemplate = new RestTemplate();
    
    private Logger _logger = LoggerFactory.getLogger(MLModelConnector.class);

    public void addToRekognitionQueue(HashMap<String, String> data){
        try{
            _logger.info("Data sent to rekognition queue");
            _restTemplate.postForObject(_pythonServerURL + "rekognition-queue", data, String.class);
        }catch (Exception e){
            _logger.error("Failed to send data to rekognition queue");
            _logger.error(e.toString());
        }
    }

}
