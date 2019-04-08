package com.norofff.team1.footballapi.controller;


import com.norofff.team1.footballapi.model.Address;
import com.norofff.team1.footballapi.service.Address_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Address_Controller {
    private final Address_Service address_service;

    @Autowired
    public Address_Controller(Address_Service address_service){
        this.address_service = address_service;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAll() {
        try {
            List<Address> character_classes = address_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
