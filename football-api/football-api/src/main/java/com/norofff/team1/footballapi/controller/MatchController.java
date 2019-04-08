package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Match;
import com.norofff.team1.footballapi.service.Match_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class MatchController {
    private final Match_Service match_service;

    @Autowired
    public MatchController(Match_Service match_service){
        this.match_service = match_service;
    }

    @GetMapping("/match")
    public ResponseEntity<List<Match>> findAll() {
        try {
            List<Match> matches = match_service.findAll();
            return new ResponseEntity<>(matches, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
