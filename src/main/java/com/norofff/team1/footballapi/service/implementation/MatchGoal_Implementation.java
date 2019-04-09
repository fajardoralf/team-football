package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.MatchGoal;
import com.norofff.team1.footballapi.repository.MatchGoal_Repository;
import com.norofff.team1.footballapi.service.MatchGoal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchGoal_Implementation implements MatchGoal_Service {
    private final MatchGoal_Repository matchGoal_repository;
    @Autowired
    public MatchGoal_Implementation(MatchGoal_Repository match_repository){
        this.matchGoal_repository = match_repository;
    }

    public List<MatchGoal> findAll() {
        return matchGoal_repository.findAll();
    }

    public MatchGoal getOne(int id) {return matchGoal_repository.getOne(id);}

    public MatchGoal create(MatchGoal matchGoal) {return matchGoal_repository.save(matchGoal);}

    public MatchGoal update(int id, MatchGoal matchGoal){
        matchGoal.setMatch_id(id);
        return matchGoal_repository.save(matchGoal);
    }

    public void delete(int id){
        try{
            matchGoal_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
