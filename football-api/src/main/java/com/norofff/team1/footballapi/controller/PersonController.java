package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Person;
import com.norofff.team1.footballapi.service.Person_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    private final Person_Service person_service;

    @Autowired
    public PersonController(Person_Service person_service){
        this.person_service = person_service;
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll() {
        try {
            List<Person> character_classes = person_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("person/{id}")
    public ResponseEntity<Person> getOne(@PathVariable int id){
        try{
            Person person = person_service.getOne(id);
            return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<Person> create(@RequestBody Person person){
        try{
            person_service.create(person);
            return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




}
