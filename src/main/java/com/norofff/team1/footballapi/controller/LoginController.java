package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MyUserPrincipal;
import com.norofff.team1.footballapi.model.Users;
import com.norofff.team1.footballapi.service.MyUserDetailsService;
import com.norofff.team1.footballapi.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

@RestController
public class LoginController {

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private User_Service userService;

    @GetMapping("/userdetails/{username}")
    public ResponseEntity<Optional<Users>> currUnserName(@PathVariable String username){
        try {
            Optional<Users> user = userService.findByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
