package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Location;
import com.norofff.team1.footballapi.service.GoalType_Service;
import com.norofff.team1.footballapi.service.Location_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    private final Location_Service location_service;

    @Autowired
    public LocationController(Location_Service location_service){
        this.location_service = location_service;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> findAll() {
        try {
            List<Location> goalTypes = location_service.findAll();
            return new ResponseEntity<>(goalTypes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
