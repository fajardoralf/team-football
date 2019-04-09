package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Result;
import com.norofff.team1.footballapi.service.Result_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResultController {
    private final Result_Service result_service;

    @Autowired
    public ResultController(Result_Service result_service){
        this.result_service = result_service;
    }

    @GetMapping("/result")
    public ResponseEntity<List<Result>> findAll() {
        try {
            List<Result> character_classes = result_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
