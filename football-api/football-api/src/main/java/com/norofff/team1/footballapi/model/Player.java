package com.norofff.team1.footballapi.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    private int player_id;
    private String normal_position;
    private String number;
    private int person_id;
    private int team_id;

    public Player() {
    }
}
