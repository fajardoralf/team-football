package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Season;
import com.norofff.team1.footballapi.repository.Season_Repository;
import com.norofff.team1.footballapi.service.Season_Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Season_Implementation implements Season_Service {
    private final Season_Repository season_repository;

    @Autowired
    public Season_Implementation(Season_Repository season_repository) {
        this.season_repository = season_repository;
    }

    public List<Season> findAll() {
        return season_repository.findAll();
    }

}
