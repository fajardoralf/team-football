package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Season;
import com.norofff.team1.footballapi.service.Season_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeasonController {
    private final Season_Service season_service;

    @Autowired
    public SeasonController(Season_Service season_service){
        this.season_service = season_service;
    }

    @GetMapping("/season")
    public ResponseEntity<List<Season>> findAll() {
        try {
            List<Season> character_classes = season_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}