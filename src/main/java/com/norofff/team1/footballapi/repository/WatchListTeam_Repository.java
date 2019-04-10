package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.WatchListTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchListTeam_Repository extends JpaRepository<WatchListTeam, Integer> {
    List<WatchListTeam> findAll();

    WatchListTeam getOne(Integer integer);
    WatchListTeam save(WatchListTeam watchListTeam);

    void deleteById(int id);
}
