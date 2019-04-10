package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.WatchListPlayer;
import com.norofff.team1.footballapi.model.WatchListTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListPlayer_Repository extends JpaRepository<WatchListPlayer, Integer> {
    List<WatchListPlayer> findAll();

    WatchListPlayer getOne(Integer integer);
    WatchListPlayer save(WatchListPlayer watchListPlayer);

    void deleteById(int id);
}
