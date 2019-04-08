package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.GoalType;
import com.norofff.team1.footballapi.repository.GoalType_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalType_Implementation {
    private final GoalType_Repository goalType_repository;

    @Autowired
    public GoalType_Implementation(GoalType_Repository goalType_repository){
        this.goalType_repository = goalType_repository;
    }

    public List<GoalType> findAll() {
        return goalType_repository.findAll();
    }
}
