package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.model.MatchPositionId;
import com.norofff.team1.footballapi.service.MatchPosition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MatchPositionController {
    private final MatchPosition_Service matchPosition_service;

    @Autowired
    public MatchPositionController(MatchPosition_Service matchPosition_service){
        this.matchPosition_service = matchPosition_service;
    }

    @GetMapping("/matchposition")
    public ResponseEntity<List<MatchPosition>> findAll() {
        try {
            List<MatchPosition> matchPositions = matchPosition_service.findAll();
            return new ResponseEntity<>(matchPositions, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/matchposition/{matchId}/{playerId}")
    public ResponseEntity<MatchPosition> getOne(@PathVariable int matchId, @PathVariable int playerId){
        MatchPositionId matchPosId = new MatchPositionId(playerId, matchId);
        System.out.println("matchPosId= " + matchId + " " + playerId);

        try{
            MatchPosition matchPosition = matchPosition_service.getOne(matchPosId);
            System.out.println("line 39" + matchPosition);
            return new ResponseEntity<>(matchPosition, HttpStatus.OK);
        }catch(DataAccessException e){
            System.out.println("--");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@PostMapping("/matchposition")

    public ResponseEntity<MatchPosition> create(@RequestBody MatchPosition matchPosition){
        try{
            matchPosition_service.create(matchPosition);
            return new ResponseEntity<>(matchPosition, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }*/

    /*@PutMapping(value = "/matchposition/{id}")
    public ResponseEntity<MatchPosition> update(@PathVariable int id, @RequestBody MatchPosition matchPosition){
        try{
            matchPosition_service.update(id, matchPosition);
            return new ResponseEntity<>(matchPosition, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/

    /*@DeleteMapping(value = "/matchposition/{id}")
    public void delete(@PathVariable int id){
        matchPosition_service.delete(id);
    }*/

}
