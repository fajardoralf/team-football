package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Team;
import com.norofff.team1.footballapi.service.Team_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TeamController {
    private final Team_Service team_service;

    @Autowired
    public TeamController(Team_Service team_service){
        this.team_service = team_service;
    }

    @GetMapping("/team")
    public ResponseEntity<List<Team>> findAll() {
        try {
            List<Team> character_classes = team_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("team/{id}")
    public ResponseEntity<Team> getOne(@PathVariable int id){
        try{
            Team team = team_service.getOne(id);
            return new ResponseEntity<>(team, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/team")
    public ResponseEntity<Team> create(@RequestBody Team team){
        try{
            team_service.create(team);
            return new ResponseEntity<>(team, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //To create in postman
    @PostMapping("/team/list")
    public ResponseEntity<Team[]> create(@RequestBody Team[] teams){
        try{
            for (int i=0; i<teams.length;i++) {
                team_service.create(teams[i]);
            }
            return new ResponseEntity<Team[]>(teams, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/team/{id}")
    public ResponseEntity<Team> update(@PathVariable int id, @RequestBody Team team){
        try{
            team_service.update(id, team);
            return new ResponseEntity<>(team, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/team/{id}")
    public void delete(@PathVariable int id){
        team_service.delete(id);
        }
}
