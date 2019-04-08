package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Match;
import com.norofff.team1.footballapi.repository.Match_Repository;
import com.norofff.team1.footballapi.service.Match_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Match_Implementation implements Match_Service {
    private final Match_Repository match_repository;

    @Autowired
    public Match_Implementation(Match_Repository match_repository){
        this.match_repository = match_repository;
    }

    public List<Match> findAll() {
        return match_repository.findAll();
    }
}
