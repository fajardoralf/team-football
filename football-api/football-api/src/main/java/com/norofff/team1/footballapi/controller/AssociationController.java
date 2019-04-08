package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Association;
import com.norofff.team1.footballapi.service.Association_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AssociationController {
    private final Association_Service association_service;

    @Autowired
    public AssociationController(Association_Service association_service){
        this.association_service = association_service;
    }

    @GetMapping("/association")
    public ResponseEntity<List<Association>> findAll() {
        try {
            List<Association> associations = association_service.findAll();
            return new ResponseEntity<>(associations, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
