package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Season;
import com.norofff.team1.footballapi.service.Season_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SeasonController {
    private final Season_Service season_service;

    @Autowired
    public SeasonController(Season_Service season_service){
        this.season_service = season_service;
    }

    @GetMapping("/season")
    public ResponseEntity<List<Season>> findAll() {
        try {
            List<Season> character_classes = season_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("season/{id}")
    public ResponseEntity<Season> getOne(@PathVariable int id){
        try{
            Season season = season_service.getOne(id);
            return new ResponseEntity<>(season, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/season")
    public ResponseEntity<Season> create(@RequestBody Season season){
        try{
            season_service.create(season);
            return new ResponseEntity<>(season, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/season/{id}")
    public ResponseEntity<Season> update(@PathVariable int id, @RequestBody Season season){
        try{
            season_service.update(id, season);
            return new ResponseEntity<>(season, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/season/{id}")
    public void delete(@PathVariable int id){
        season_service.delete(id);
    }
}