package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.WatchListPlayer;

import java.util.List;

public interface WatchListPlayer_Service {
    List<WatchListPlayer> findAll();

    WatchListPlayer getOne(int id);
    WatchListPlayer create(WatchListPlayer watchListPlayer);
    WatchListPlayer update(int id, WatchListPlayer watchListPlayer);
    void delete(int id);
}
