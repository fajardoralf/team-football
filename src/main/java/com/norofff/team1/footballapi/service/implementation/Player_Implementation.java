//Player_Implementation
package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Player;
import com.norofff.team1.footballapi.repository.Player_Repository;
import com.norofff.team1.footballapi.service.Player_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Player_Implementation implements Player_Service {
    private final Player_Repository player_repository;
    @Autowired
    public Player_Implementation(Player_Repository player_repository){
        this.player_repository = player_repository;
    }

    public List<Player> findAll() {
        return player_repository.findAll();
    }

    public Player getOne(int id) {return player_repository.getOne(id);}

    public Player create(Player player) {return player_repository.save(player);}

    public Player update(int id, Player player){
        player.setPlayer_id(id);
        return player_repository.save(player);
    }

    public void delete(int id){
        try{
            player_repository.deleteById(id);

        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
