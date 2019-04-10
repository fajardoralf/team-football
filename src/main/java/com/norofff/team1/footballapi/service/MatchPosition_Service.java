package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.model.MatchPositionId;

import java.util.List;

public interface MatchPosition_Service {
    List<MatchPosition> findAll();

    MatchPosition getOne(MatchPositionId id);
    //MatchPosition create(MatchPosition matchPosition);
   // MatchPosition update(MatchPositionId id, MatchPosition matchPosition);
    //void delete(int id);
}
