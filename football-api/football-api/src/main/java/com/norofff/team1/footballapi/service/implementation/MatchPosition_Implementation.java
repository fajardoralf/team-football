package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.repository.MatchGoal_Repository;
import com.norofff.team1.footballapi.repository.MatchPosition_Repository;
import com.norofff.team1.footballapi.service.MatchPosition_Service;

import java.util.List;

public class MatchPosition_Implementation implements MatchPosition_Service {

    private final MatchPosition_Repository matchPosition_repository;

    public MatchPosition_Implementation(MatchPosition_Repository matchPosition_repository){
        this.matchPosition_repository = matchPosition_repository;
    }

    public List<MatchPosition> findAll() {
        return matchPosition_repository.findAll();
    }
}
