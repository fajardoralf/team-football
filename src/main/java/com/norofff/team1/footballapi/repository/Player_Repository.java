package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Player_Repository extends JpaRepository<Player, Integer> {
    List<Player> findAll();
}