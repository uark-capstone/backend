package com.example.CapstoneBackend.Controllers.UserController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    String getHelloWorld(){
        return "hello ppl!!";
    }
}
