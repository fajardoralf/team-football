package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.MatchGoal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchGoal_Repository extends JpaRepository<MatchGoal, Integer> {
    List<MatchGoal> findAll();

    MatchGoal getOne(Integer integer);
    MatchGoal save(MatchGoal matchGoal);

    void deleteById(int id);
}
