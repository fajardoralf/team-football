package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Player_Service {
    List<Player> findAll();
}