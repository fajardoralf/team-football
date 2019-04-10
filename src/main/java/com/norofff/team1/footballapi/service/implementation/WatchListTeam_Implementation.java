package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.WatchListTeam;
import com.norofff.team1.footballapi.repository.WatchListTeam_Repository;
import com.norofff.team1.footballapi.service.WatchListTeam_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListTeam_Implementation implements WatchListTeam_Service {
    private final WatchListTeam_Repository watchListTeam_repository;

    @Autowired
    public WatchListTeam_Implementation(WatchListTeam_Repository watchListTeam_repository) {
        this.watchListTeam_repository = watchListTeam_repository;
    }

    public List<WatchListTeam> findAll() {
        return watchListTeam_repository.findAll();
    }

    public WatchListTeam getOne(int id) {return watchListTeam_repository.getOne(id);}

    public WatchListTeam create(WatchListTeam watchListTeam) {return watchListTeam_repository.save(watchListTeam);}

    public WatchListTeam update(int id, WatchListTeam watchListTeam){
        watchListTeam.setWatchList_team_id(id);
        return watchListTeam_repository.save(watchListTeam);
    }

    public void delete(int id){
        try{
            watchListTeam_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
