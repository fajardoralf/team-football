package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MyUserPrincipal;
import com.norofff.team1.footballapi.model.Users;
import com.norofff.team1.footballapi.service.MyUserDetailsService;
import com.norofff.team1.footballapi.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
public class LoginController {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private User_Service userService;

    @GetMapping("/userdetails")
    public Optional<Users> currUnserName(Principal authentication){
        return userService.findByUsername(authentication.getName());
    }
}
