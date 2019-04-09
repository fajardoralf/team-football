package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Owner;
import com.norofff.team1.footballapi.service.Owner_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {
    private final Owner_Service owner_service;

    @Autowired
    public OwnerController(Owner_Service owner_service){
        this.owner_service = owner_service;
    }

    @GetMapping("/owner")
    public ResponseEntity<List<Owner>> findAll() {
        try {
            List<Owner> character_classes = owner_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
