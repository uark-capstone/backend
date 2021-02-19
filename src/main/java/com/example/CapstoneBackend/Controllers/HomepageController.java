package com.example.CapstoneBackend.Controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/")
public class HomepageController {
    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Object> isRunning() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body("It's running!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
