package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Team_Repository extends JpaRepository<Team, Integer> {
    List<Team> findAll();

    Team getOne(int id);
    Team save(Team team);
    //Team update(int id, Team address);
    void deleteById(int id);
}