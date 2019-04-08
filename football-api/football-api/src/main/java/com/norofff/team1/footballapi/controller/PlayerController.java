package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Player;
import com.norofff.team1.footballapi.service.Player_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
