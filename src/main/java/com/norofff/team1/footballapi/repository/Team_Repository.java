package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Team_Repository extends JpaRepository<Team, Integer> {
    List<Team> findAll();

    Team getOne(int id);
    Team save(Team team);
    void deleteById(int id);
}