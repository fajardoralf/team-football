package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Users;
import com.norofff.team1.footballapi.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    private final User_Service user_service;

    @Autowired
    public UserController(User_Service user_service){
        this.user_service = user_service;
    }

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<Users>> findAll() {
        try {
            List<Users> character_classes = user_service.findAll();
            return new ResponseEntity<>(character_classes, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Users> getOne(@PathVariable int id){
        try{
            Users team = user_service.getOne(id);
            return new ResponseEntity<>(team, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Users> create(@RequestBody Users users){
        try{
            user_service.encodePassword(users);
            return new ResponseEntity<>(users, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<Users> update(@PathVariable int id, @RequestBody Users users){
        try{
            user_service.update(id, users);
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable int id){
        user_service.delete(id);
    }
}
