package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Association;
import com.norofff.team1.footballapi.service.Association_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
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
            return new ResponseEntity<>(associations, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("association/{id}")
    public ResponseEntity<Association> getOne(@PathVariable int id){
        try{
            Association association = association_service.getOne(id);
            return new ResponseEntity<>(association, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/association")
    public ResponseEntity<Association> create(@RequestBody Association association){
        try{
            association_service.create(association);
            return new ResponseEntity<>(association, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/association/{id}")
    public ResponseEntity<Association> update(@PathVariable int id, @RequestBody Association association){
        try{
            association_service.update(id, association);
            return new ResponseEntity<>(association, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/association/{id}")
    public void delete(@PathVariable int id){
        association_service.delete(id);
    }
}
