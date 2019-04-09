package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.GoalType;

import java.util.List;

public interface GoalType_Service {
    List<GoalType> findAll();

    GoalType getOne(int id);
    GoalType create(GoalType goalType);
    GoalType update(int id, GoalType goalType);
    void delete(int id);
}
