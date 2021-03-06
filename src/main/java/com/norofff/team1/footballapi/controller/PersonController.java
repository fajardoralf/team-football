package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Person;
import com.norofff.team1.footballapi.service.Person_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
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
            return new ResponseEntity<>(character_classes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("person/{id}")
    public ResponseEntity<Person> getOne(@PathVariable int id){
        try{
            Person person = person_service.getOne(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //get team name by personid
    @GetMapping("personname/{id}")
    public ResponseEntity<Object> getTeamByPersonId(@PathVariable int id){
        try{
            Object person = person_service.getTeamByPersonId(id);
            return new ResponseEntity<>(person, HttpStatus.OK);
        } catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/person")
    public ResponseEntity<Person> create(@RequestBody Person person){
        try{
            person_service.create(person);
            return new ResponseEntity<>(person, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/person/list")
    public ResponseEntity<Person[]> create(@RequestBody Person[] persons){
        try{
            for (int i = 0; i < persons.length; i++) {
                person_service.create(persons[i]);
            }
            return new ResponseEntity<>(persons, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/person/{id}")
    public ResponseEntity<Person> update(@PathVariable int id, @RequestBody Person person){
        try{
            person_service.update(id, person);
            return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/person/{id}")
    public void delete(@PathVariable int id){
        person_service.delete(id);
    }
}

