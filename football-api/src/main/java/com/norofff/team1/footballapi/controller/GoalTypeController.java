package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.GoalType;
import com.norofff.team1.footballapi.service.GoalType_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoalTypeController {
    private final GoalType_Service goalType_service;

    @Autowired
    public GoalTypeController(GoalType_Service goalType_service){
        this.goalType_service = goalType_service;
    }

    @GetMapping("/goaltype")
    public ResponseEntity<List<GoalType>> findAll() {
        try {
            List<GoalType> goalTypes = goalType_service.findAll();
            return new ResponseEntity<>(goalTypes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
