package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Coach;
import com.norofff.team1.footballapi.repository.Coach_Repository;
import com.norofff.team1.footballapi.service.Coach_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Coach_Implementation implements Coach_Service {
    private final Coach_Repository coach_repository;
    @Autowired
    public Coach_Implementation(Coach_Repository coach_repository){
        this.coach_repository = coach_repository;
    }

    public List<Coach> findAll() {
        return coach_repository.findAll();
    }

    public Coach create(Coach coach) {return coach_repository.save(coach);}

    public Coach update(int id, Coach coach){
        coach.setCoach_id(id);
        return coach_repository.save(coach);
    }

    public void delete(int id){
        try{
            coach_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
