package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Contact;
import com.norofff.team1.footballapi.service.Contact_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactsController {
    private final Contact_Service contact_service;

    @Autowired
    public ContactsController(Contact_Service contact_service){
        this.contact_service = contact_service;
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> findAll() {
        try {
            List<Contact> associations = contact_service.findAll();
            return new ResponseEntity<>(associations, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
