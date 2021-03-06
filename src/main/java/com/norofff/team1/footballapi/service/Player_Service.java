//Player_Service
package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Person;
import com.norofff.team1.footballapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Player_Service {
    List<Player> findAll();

    Player getOne(int id);
    Player create(Player player);
    Player update(int id, Player player);
    void delete(int id);

    List<Object> findAllPlayersWithName();

    List<Object> findAllPlayersWithNameAndTeam();

    List<Object> findAllPlayersLimited();

    List<Player> findPlayerTeam(int id);

    List<Object> findAllPlayersWithNameByTeamId(int id);
}
