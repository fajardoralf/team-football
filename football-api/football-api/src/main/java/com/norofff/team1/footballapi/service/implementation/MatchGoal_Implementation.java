package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.MatchGoal;
import com.norofff.team1.footballapi.repository.MatchGoal_Repository;

import java.util.List;

public class MatchGoal_Implementation {
    private final MatchGoal_Repository matchGoal_repository;

    public MatchGoal_Implementation(MatchGoal_Repository match_repository){
        this.matchGoal_repository = match_repository;
    }

    public List<MatchGoal> findAll() {
        return matchGoal_repository.findAll();
    }
}
