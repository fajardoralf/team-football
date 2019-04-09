package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MatchGoal;
import com.norofff.team1.footballapi.service.MatchGoal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchGoalController {
    private final MatchGoal_Service matchGoal_service;

    @Autowired
    public MatchGoalController(MatchGoal_Service matchGoal_service){
        this.matchGoal_service = matchGoal_service;
    }

    @GetMapping("/matchgoal")
    public ResponseEntity<List<MatchGoal>> findAll() {
        try {
            List<MatchGoal> matchGoals = matchGoal_service.findAll();
            return new ResponseEntity<>(matchGoals, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("matchgoal/{id}")
    public ResponseEntity<MatchGoal> getOne(@PathVariable int id){
        try{
            MatchGoal matchGoal = matchGoal_service.getOne(id);
            return new ResponseEntity<>(matchGoal, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/matchgoal")
    public ResponseEntity<MatchGoal> create(@RequestBody MatchGoal matchGoal){
        try{
            matchGoal_service.create(matchGoal);
            return new ResponseEntity<>(matchGoal, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/matchgoal/{id}")
    public ResponseEntity<MatchGoal> update(@PathVariable int id, @RequestBody MatchGoal matchGoal){
        try{
            matchGoal_service.update(id, matchGoal);
            return new ResponseEntity<>(matchGoal, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/matchgoal/{id}")
    public void delete(@PathVariable int id){
        matchGoal_service.delete(id);
    }
}
