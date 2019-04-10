package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.WatchListPlayer;
import com.norofff.team1.footballapi.repository.WatchListPlayer_Repository;
import com.norofff.team1.footballapi.service.WatchListPlayer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchListPLayer_Implementation implements WatchListPlayer_Service {
    private final WatchListPlayer_Repository watchListPlayer_repository;

    @Autowired
    public WatchListPLayer_Implementation(WatchListPlayer_Repository watchListPlayer_repository) {
        this.watchListPlayer_repository = watchListPlayer_repository;
    }

    public List<WatchListPlayer> findAll() {
        return watchListPlayer_repository.findAll();
    }

    public WatchListPlayer getOne(int id) {return watchListPlayer_repository.getOne(id);}

    public WatchListPlayer create(WatchListPlayer watchListPlayer) {return watchListPlayer_repository.save(watchListPlayer);}

    public WatchListPlayer update(int id, WatchListPlayer watchListPlayer){
        watchListPlayer.setWatchList_player_id(id);
        return watchListPlayer_repository.save(watchListPlayer);
    }

    public void delete(int id){
        try{
            watchListPlayer_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
