package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.service.MatchPosition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MatchPositionController {
    private final MatchPosition_Service matchPosition_service;

    @Autowired
    public MatchPositionController(MatchPosition_Service matchPosition_service){
        this.matchPosition_service = matchPosition_service;
    }

    @GetMapping("/matchposition")
    public ResponseEntity<List<MatchPosition>> findAll() {
        try {
            List<MatchPosition> matchPositions = matchPosition_service.findAll();
            return new ResponseEntity<>(matchPositions, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
