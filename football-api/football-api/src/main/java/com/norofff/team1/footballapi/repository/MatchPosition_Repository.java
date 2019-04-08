package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.MatchPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchPosition_Repository extends JpaRepository<MatchPosition, Integer> {
    List<MatchPosition> findAll();
}