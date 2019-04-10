package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Users_Repository extends JpaRepository<Users, Integer> {
    List<Users> findAll();

    Users getOne(int id);
    Users save(Users users);
    void deleteById(int id);
}