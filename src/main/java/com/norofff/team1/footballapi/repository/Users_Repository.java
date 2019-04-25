package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Users_Repository extends JpaRepository<Users, Integer> {
    List<Users> findAll();

    Users getOne(int id);
    Users save(Users users);
    void deleteById(int id);

    @Query(value = "select * from users where username=?", nativeQuery = true)
    Optional<Users> findByUsername(String username);

}