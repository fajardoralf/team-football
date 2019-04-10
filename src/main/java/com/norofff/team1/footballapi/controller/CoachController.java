package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Coach;
import com.norofff.team1.footballapi.service.Coach_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CoachController {
    private final Coach_Service coach_service;

    @Autowired
    public CoachController(Coach_Service association_service){
        this.coach_service = association_service;
    }

    @GetMapping("/coach")
    public ResponseEntity<List<Coach>> findAll() {
        try {
            List<Coach> associations = coach_service.findAll();
            return new ResponseEntity<>(associations, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("coach/{id}")
    public ResponseEntity<Coach> getOne(@PathVariable int id){
        try{
            Coach coach = coach_service.getOne(id);
            return new ResponseEntity<>(coach, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/coach")
    public ResponseEntity<Coach> create(@RequestBody Coach coach){
        try{
            coach_service.create(coach);
            return new ResponseEntity<>(coach, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/coach/{id}")
    public ResponseEntity<Coach> update(@PathVariable int id, @RequestBody Coach coach){
        try{
            coach_service.update(id, coach);
            return new ResponseEntity<>(coach, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/coach/{id}")
    public void delete(@PathVariable int id){
        coach_service.delete(id);
    }
}
