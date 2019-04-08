package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Season_Repository extends JpaRepository<Season, Integer> {
    List<Season> findAll();
}
