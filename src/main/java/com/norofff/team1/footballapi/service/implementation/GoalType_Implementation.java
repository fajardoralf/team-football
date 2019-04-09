package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.GoalType;
import com.norofff.team1.footballapi.repository.GoalType_Repository;
import com.norofff.team1.footballapi.service.GoalType_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalType_Implementation implements GoalType_Service {
    private final GoalType_Repository goalType_repository;

    @Autowired
    public GoalType_Implementation(GoalType_Repository goalType_repository){
        this.goalType_repository = goalType_repository;
    }

    public List<GoalType> findAll() {
        return goalType_repository.findAll();
    }

    public GoalType create(GoalType goalType) {return goalType_repository.save(goalType);}

    public GoalType update(int id, GoalType goalType){
        goalType.setGoal_type_id(id);
        return goalType_repository.save(goalType);
    }

    public void delete(int id){
        try{
            goalType_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
