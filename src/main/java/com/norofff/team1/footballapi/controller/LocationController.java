package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Location;
import com.norofff.team1.footballapi.service.Location_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LocationController {
    private final Location_Service location_service;

    @Autowired
    public LocationController(Location_Service location_service){
        this.location_service = location_service;
    }

    @GetMapping("/location")
    public ResponseEntity<List<Location>> findAll() {
        try {
            List<Location> goalTypes = location_service.findAll();
            return new ResponseEntity<>(goalTypes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("location/{id}")
    public ResponseEntity<Location> getOne(@PathVariable int id){
        try{
            Location location = location_service.getOne(id);
            return new ResponseEntity<>(location, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/location")
    public ResponseEntity<Location> create(@RequestBody Location location){
        try{
            location_service.create(location);
            return new ResponseEntity<>(location, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/location/list")
    public ResponseEntity<Location[]> create(@RequestBody Location[] locations){
        try{
            for (int i = 0; i <locations.length; i++) {
                location_service.create(locations[i]);
            }
            return new ResponseEntity<>(locations, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/location/{id}")
    public ResponseEntity<Location> update(@PathVariable int id, @RequestBody Location location){
        try{
            location_service.update(id, location);
            return new ResponseEntity<>(location, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/location/{id}")
    public void delete(@PathVariable int id){
        location_service.delete(id);
    }
}
