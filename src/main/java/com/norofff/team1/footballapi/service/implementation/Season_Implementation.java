package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Season;
import com.norofff.team1.footballapi.repository.Season_Repository;
import com.norofff.team1.footballapi.service.Season_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Season_Implementation implements Season_Service {
    private final Season_Repository season_repository;

    @Autowired
    public Season_Implementation(Season_Repository season_repository) {
        this.season_repository = season_repository;
    }

    public List<Season> findAll() {
        return season_repository.findAll();
    }

    public Season getOne(int id) {return season_repository.getOne(id);}


    public Season create(Season season) {return season_repository.save(season);}

    public Season update(int id, Season season){
        season.setSeason_id(id);
        return season_repository.save(season);
    }

    public void delete(int id){
        try{
            season_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }

}
