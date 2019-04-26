package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "match_position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchPosition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matchposition_id")
    private int matchPosition_id;
    private int player_id;
    private int match_id;
    private String position;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Player.class)
    @JoinColumn(name = "player_id", updatable = false, insertable = false)
    private Player player;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Match.class)
    @JoinColumn(name = "match_id", updatable = false, insertable = false)
    private Match match;

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


