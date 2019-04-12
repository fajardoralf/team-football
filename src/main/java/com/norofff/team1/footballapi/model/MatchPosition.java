package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "match_position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchPosition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchPosition_id;
    private int player_id;
    private int match_id;
    private String position;

    public MatchPosition(){}

    public MatchPosition(int matchPosition_id, int player_id, int match_id, String position) {
        this.matchPosition_id = matchPosition_id;
        this.player_id = player_id;
        this.match_id = match_id;
        this.position = position;
    }
    //postman constructor
    public MatchPosition(int player_id, int match_id, String position) {
        this.player_id = player_id;
        this.match_id = match_id;
        this.position = position;
    }
}


