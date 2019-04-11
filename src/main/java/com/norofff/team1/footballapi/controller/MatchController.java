package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Match;
import com.norofff.team1.footballapi.service.Match_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MatchController {
    private final Match_Service match_service;

    @Autowired
    public MatchController(Match_Service match_service){
        this.match_service = match_service;
    }

    @GetMapping("/match")
    public ResponseEntity<List<Match>> findAll() {
        try {
            List<Match> matches = match_service.findAll();
            return new ResponseEntity<>(matches, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getOne(@PathVariable int id){
        try{
            Match match = match_service.getOne(id);
            return new ResponseEntity<>(match, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/match")
    public ResponseEntity<Match> create(@RequestBody Match match){
        try{
            match_service.create(match);
            return new ResponseEntity<>(match, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/match/list")
    public ResponseEntity<Match[]> create(@RequestBody Match[] matches){
        try{
            for (int i = 0; i <matches.length-1 ; i++) {
                match_service.create(matches[i]);
            }
            return new ResponseEntity<>(matches, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/match/{id}")
    public ResponseEntity<Match> update(@PathVariable int id, @RequestBody Match match){
        try{
            match_service.update(id, match);
            return new ResponseEntity<>(match, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/match/{id}")
    public void delete(@PathVariable int id){
        match_service.delete(id);
    }
}
