package com.norofff.team1.footballapi.model;
import lombok.Data;

@Data
public class Player {
    private int player_id;
    private String normal_position;
    private String number;
    private int person_id;
    private int team_id;

    public Player() {
    }
}
