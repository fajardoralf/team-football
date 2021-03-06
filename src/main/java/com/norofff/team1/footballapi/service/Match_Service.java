package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Match;

import java.util.List;

public interface Match_Service {
    List<Match> findAll();

    Match getOne(int id);
    Match create(Match match);
    Match update(int id, Match match);
    void delete(int id);

    List<Object> findAllMatchesLimited();
}
