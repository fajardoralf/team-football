package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Owner;
import com.norofff.team1.footballapi.service.Owner_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class OwnerController {
    private final Owner_Service owner_service;

    @Autowired
    public OwnerController(Owner_Service owner_service){
        this.owner_service = owner_service;
    }

    @GetMapping("/owner")
    public ResponseEntity<List<Owner>> findAll() {
        try {
            List<Owner> character_classes = owner_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("owner/{id}")
    public ResponseEntity<Owner> getOne(@PathVariable int id){
        try{
            Owner owner = owner_service.getOne(id);
            return new ResponseEntity<>(owner, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/owner")
    public ResponseEntity<Owner> create(@RequestBody Owner owner){
        try{
            owner_service.create(owner);
            return new ResponseEntity<>(owner, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/owner/list")
    public ResponseEntity<Owner[]> create(@RequestBody Owner[] owners){
        try{
            for (int i = 0; i < owners.length; i++) {
                owner_service.create(owners[i]);
            }
            return new ResponseEntity<>(owners, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/owner/{id}")
    public ResponseEntity<Owner> update(@PathVariable int id, @RequestBody Owner owner){
        try{
            owner_service.update(id, owner);
            return new ResponseEntity<>(owner, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/owner/{id}")
    public void delete(@PathVariable int id){
        owner_service.delete(id);
    }
}
