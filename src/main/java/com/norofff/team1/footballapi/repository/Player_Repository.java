package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Player_Repository extends JpaRepository<Player, Integer> {
    List<Player> findAll();

    Player getOne(Integer integer);
    Player save(Player player);
    void deleteById(int id);

    @Query(value = "SELECT player_id, person_id, team_id,first_name, \n" +
            "last_name,normal_position, number\n" +
            "FROM player NATURAL JOIN Person;", nativeQuery = true)
    List<Object> findAllPlayersWithName();
    }
