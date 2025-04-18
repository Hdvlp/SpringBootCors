package com.springbootcors.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ApiController {

    @GetMapping("/api")
    public String getMethodName() {
        return new String("GET request page");
    }

    @PostMapping("/api")
    public String postMethodName(@RequestBody String entity) {
        return new String("POST request page");
    }
    


}
