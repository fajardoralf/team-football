package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Match_Repository extends JpaRepository<Match, Integer> {
    List<Match> findAll();
}
