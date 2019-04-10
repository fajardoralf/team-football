package com.norofff.team1.footballapi.repository;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MatchPositionId implements Serializable {
    @Column(name ="player_id")
    private int player_id;
    @Column(name = "match_id")
    private int match_id;

    public MatchPositionId(){}

    public MatchPositionId(int player_id, int match_id){
        this.player_id = player_id;
        this.match_id = match_id;
    }
}
