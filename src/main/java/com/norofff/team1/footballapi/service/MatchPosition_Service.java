package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.MatchPosition;

import java.util.List;

public interface MatchPosition_Service {
    List<MatchPosition> findAll();

    MatchPosition create(MatchPosition matchPosition);
    /*MatchPosition update(int id, MatchPosition matchPosition);
    void delete(int id);*/
}
