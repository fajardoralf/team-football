package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Coach;
import com.norofff.team1.footballapi.service.Coach_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoachController {
    private final Coach_Service coach_service;

    @Autowired
    public CoachController(Coach_Service association_service){
        this.coach_service = association_service;
    }

    @GetMapping("/coach")
    public ResponseEntity<List<Coach>> findAll() {
        try {
            List<Coach> associations = coach_service.findAll();
            return new ResponseEntity<>(associations, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
