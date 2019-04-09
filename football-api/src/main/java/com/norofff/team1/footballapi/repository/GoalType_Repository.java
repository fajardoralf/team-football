package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.GoalType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalType_Repository extends JpaRepository<GoalType, Integer> {
    List<GoalType> findAll();
}
