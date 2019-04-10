package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.WatchListPlayer;
import com.norofff.team1.footballapi.service.WatchListPlayer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class WatchListPlayerController {
    private final WatchListPlayer_Service watchListPlayer_service;

    @Autowired
    public WatchListPlayerController(WatchListPlayer_Service watchListPlayer_service){
        this.watchListPlayer_service = watchListPlayer_service;
    }

    @GetMapping("/watchlistplayer")
    public ResponseEntity<List<WatchListPlayer>> findAll() {
        try {
            List<WatchListPlayer> watchListPlayer = watchListPlayer_service.findAll();
            return new ResponseEntity<>(watchListPlayer, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("watchlistplayer/{id}")
    public ResponseEntity<WatchListPlayer> getOne(@PathVariable int id){
        try{
            WatchListPlayer watchListPlayer = watchListPlayer_service.getOne(id);
            return new ResponseEntity<>(watchListPlayer, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/watchlistplayer")
    public ResponseEntity<WatchListPlayer> create(@RequestBody WatchListPlayer watchListPlayer){
        try{
            watchListPlayer_service.create(watchListPlayer);
            return new ResponseEntity<>(watchListPlayer, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
