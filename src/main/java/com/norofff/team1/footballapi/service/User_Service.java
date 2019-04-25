package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Users;

import java.util.List;
import java.util.Optional;


public interface User_Service {
    List<Users> findAll();
    Optional<Users> findByUsername(String username);
    Users login(String username);
    Users getOne(int id);
    Users create(Users users);
    Users encodePassword(Users users);
    Users update(int id, Users users);
    void delete(int id);
}
