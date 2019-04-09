package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Player;
import com.norofff.team1.footballapi.service.Player_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    private final Player_Service player_service;

    @Autowired
    public PlayerController(Player_Service player_service){
        this.player_service = player_service;
    }

    @GetMapping("/player")
    public ResponseEntity<List<Player>> findAll() {
        try {
            List<Player> character_classes = player_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("player/{id}")
    public ResponseEntity<Player> getOne(@PathVariable int id){
        try{
            Player player = player_service.getOne(id);
            return new ResponseEntity<>(player, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/player")
    public ResponseEntity<Player> create(@RequestBody Player player){
        try{
            player_service.create(player);
            return new ResponseEntity<>(player, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/player/{id}")
    public ResponseEntity<Player> update(@PathVariable int id, @RequestBody Player player){
        try{
            player_service.update(id, player);
            return new ResponseEntity<>(player, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/player/{id}")
    public void delete(@PathVariable int id){
        player_service.delete(id);
    }
}
