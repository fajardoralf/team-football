package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.MatchGoal;
import com.norofff.team1.footballapi.service.MatchGoal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MatchGoalController {
    private final MatchGoal_Service matchGoal_service;

    @Autowired
    public MatchGoalController(MatchGoal_Service matchGoal_service){
        this.matchGoal_service = matchGoal_service;
    }

    @GetMapping("/matchgoal")
    public ResponseEntity<List<MatchGoal>> findAll() {
        try {
            List<MatchGoal> matchGoals = matchGoal_service.findAll();
            return new ResponseEntity<>(matchGoals, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("matchgoal/{id}")
    public ResponseEntity<MatchGoal> getOne(@PathVariable int id){
        try{
            MatchGoal matchGoal = matchGoal_service.getOne(id);
            return new ResponseEntity<>(matchGoal, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("matchidgoal/{id}")
    public ResponseEntity<List<MatchGoal>> findMatchIdGoal(@PathVariable int id){
        try{
            List<MatchGoal> playerTeam = matchGoal_service.findMatchIdGoal(id);
            return new ResponseEntity<>(playerTeam, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/matchgoal")
    public ResponseEntity<MatchGoal> create(@RequestBody MatchGoal matchGoal){
        try{
            matchGoal_service.create(matchGoal);
            return new ResponseEntity<>(matchGoal, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/matchgoal/list")
    public ResponseEntity<MatchGoal[]> create(@RequestBody MatchGoal[] matchGoals){
        try{
            for (int i = 0; i < matchGoals.length-1; i++) {
                matchGoal_service.create(matchGoals[i]);
            }
            return new ResponseEntity<>(matchGoals, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/matchgoal/{id}")
    public ResponseEntity<MatchGoal> update(@PathVariable int id, @RequestBody MatchGoal matchGoal){
        try{
            matchGoal_service.update(id, matchGoal);
            return new ResponseEntity<>(matchGoal, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/matchgoal/{id}")
    public void delete(@PathVariable int id){
        matchGoal_service.delete(id);
    }
}
