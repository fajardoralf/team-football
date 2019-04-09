package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Team;
import com.norofff.team1.footballapi.service.Team_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    private final Team_Service team_service;

    @Autowired
    public TeamController(Team_Service team_service){
        this.team_service = team_service;
    }

    @GetMapping("/team")
    public ResponseEntity<List<Team>> findAll() {
        try {
            List<Team> character_classes = team_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/team")
    public ResponseEntity<Team> create(@RequestBody Team team){
        try{
            team_service.create(team);
            return new ResponseEntity<>(team, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/team/{id}")
    public void delete(@PathVariable int id){
        team_service.delete(id);
        }
}
