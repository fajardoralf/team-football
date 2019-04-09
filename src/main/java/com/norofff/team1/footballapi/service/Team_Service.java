package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Team;


import java.util.List;

public interface Team_Service {
    List<Team> findAll();

    Team getOne(int id);
    Team create(Team team);
    Team update(int id, Team address);
    void delete(int id);
}
