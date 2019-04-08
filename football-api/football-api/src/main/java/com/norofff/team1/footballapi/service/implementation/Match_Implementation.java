package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Match;
import com.norofff.team1.footballapi.repository.Match_Repository;

import java.util.List;

public class Match_Implementation {
    private final Match_Repository match_repository;

    public Match_Implementation(Match_Repository match_repository){
        this.match_repository = match_repository;
    }

    public List<Match> findAll() {
        return match_repository.findAll();
    }
}
