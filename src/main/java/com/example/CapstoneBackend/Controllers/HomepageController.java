package com.example.CapstoneBackend.Controllers;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/")
public class HomepageController {
    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> isRunning() {
        try {
            return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body("It's running!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(e.getMessage());
        }
    }
}
