package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.repository.MatchGoal_Repository;
import com.norofff.team1.footballapi.repository.MatchPosition_Repository;
import com.norofff.team1.footballapi.service.MatchPosition_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchPosition_Implementation implements MatchPosition_Service {

    private final MatchPosition_Repository matchPosition_repository;
    @Autowired
    public MatchPosition_Implementation(MatchPosition_Repository matchPosition_repository){
        this.matchPosition_repository = matchPosition_repository;
    }

    public List<MatchPosition> findAll() {
        return matchPosition_repository.findAll();
    }
}