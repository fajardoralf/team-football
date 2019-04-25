package com.norofff.team1.footballapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "Hello Welcome to our database";
    }
}
