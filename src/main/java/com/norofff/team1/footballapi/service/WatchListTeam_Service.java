package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.WatchListTeam;

import java.util.List;

public interface WatchListTeam_Service {
    List<WatchListTeam> findAll();

    WatchListTeam getOne(int id);
    WatchListTeam create(WatchListTeam watchListTeam);
    WatchListTeam update(int id, WatchListTeam watchListTeam);
    void delete(int id);
}
