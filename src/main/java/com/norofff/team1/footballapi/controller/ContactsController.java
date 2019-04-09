package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Contact;
import com.norofff.team1.footballapi.service.Contact_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactsController {
    private final Contact_Service contact_service;

    @Autowired
    public ContactsController(Contact_Service contact_service){
        this.contact_service = contact_service;
    }

    @GetMapping("/contact")
    public ResponseEntity<List<Contact>> findAll() {
        try {
            List<Contact> associations = contact_service.findAll();
            return new ResponseEntity<>(associations, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("contact/{id}")
    public ResponseEntity<Contact> getOne(@PathVariable int id){
        try{
            Contact contact = contact_service.getOne(id);
            return new ResponseEntity<>(contact, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> create(@RequestBody Contact contact){
        try{
            contact_service.create(contact);
            return new ResponseEntity<>(contact, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/contact/{id}")
    public ResponseEntity<Contact> update(@PathVariable int id, @RequestBody Contact contact){
        try{
            contact_service.update(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/contact/{id}")
    public void delete(@PathVariable int id){
        contact_service.delete(id);
    }
}
