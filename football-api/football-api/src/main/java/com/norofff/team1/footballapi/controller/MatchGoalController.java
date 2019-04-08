package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MatchGoal;
import com.norofff.team1.footballapi.service.MatchGoal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatchGoalController {
    private final MatchGoal_Service matchGoal_service;

    @Autowired
    public MatchGoalController(MatchGoal_Service matchGoal_service){
        this.matchGoal_service = matchGoal_service;
    }

    @GetMapping("/matchGoal")
    public ResponseEntity<List<MatchGoal>> findAll() {
        try {
            List<MatchGoal> matchGoals = matchGoal_service.findAll();
            return new ResponseEntity<>(matchGoals, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
