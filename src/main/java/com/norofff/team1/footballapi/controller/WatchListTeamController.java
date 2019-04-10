package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.WatchListTeam;
import com.norofff.team1.footballapi.repository.WatchListTeam_Repository;
import com.norofff.team1.footballapi.service.WatchListTeam_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@RestController
public class WatchListTeamController {
    private final WatchListTeam_Service watchListTeam_service;

    @Autowired
    public WatchListTeamController(WatchListTeam_Service watchListTeam_service){
        this.watchListTeam_service = watchListTeam_service;
    }

    @GetMapping("/watchlistteam")
    public ResponseEntity<List<WatchListTeam>> findAll() {
        try {
            List<WatchListTeam> watchListTeam = watchListTeam_service.findAll();
            return new ResponseEntity<>(watchListTeam, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("watchlistteam/{id}")
    public ResponseEntity<WatchListTeam> getOne(@PathVariable int id){
        try{
            WatchListTeam watchListTeam = watchListTeam_service.getOne(id);
            return new ResponseEntity<>(watchListTeam, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/watchlistteam")
    public ResponseEntity<WatchListTeam> create(@RequestBody WatchListTeam watchListTeam){
        try{
            watchListTeam_service.create(watchListTeam);
            return new ResponseEntity<>(watchListTeam, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/watchlistteam/{id}")
    public ResponseEntity<WatchListTeam> update(@PathVariable int id, @RequestBody WatchListTeam watchListTeam){
        try{
            watchListTeam_service.update(id, watchListTeam);
            return new ResponseEntity<>(watchListTeam, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/watchlistteam/{id}")
    public void delete(@PathVariable int id){
        watchListTeam_service.delete(id);
    }
}
