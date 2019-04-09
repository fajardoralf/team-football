package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Address;
import com.norofff.team1.footballapi.service.Address_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Address_Controller {
    private final Address_Service address_service;

    @Autowired
    public Address_Controller(Address_Service address_service){
        this.address_service = address_service;
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAll() {
        try {
            List<Address> addresses = address_service.findAll();
            return new ResponseEntity<>(addresses, HttpStatus.FOUND);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("address/{id}")
    public ResponseEntity<Address> getOne(@PathVariable int id){
        try{
            Address address = address_service.getOne(id);
            return new ResponseEntity<>(address, HttpStatus.FOUND);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/address")
    public ResponseEntity<Address> create(@RequestBody Address address){
        try{
            address_service.create(address);
            return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*@PutMapping
    public ResponseEntity<Address> update(@PathVariable int id, @RequestBody Address address){
        try{
            address_service.update(id, address);
            return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/


    @DeleteMapping(value = "/address/{id}")
    public void delete(@PathVariable int id){
        address_service.delete(id);

    }
}
