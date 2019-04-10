package com.norofff.team1.footballapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatchPositionId)) return false;
        MatchPositionId that = (MatchPositionId) o;
        return Objects.equals(getPlayer_id(), that.getPlayer_id()) &&
                Objects.equals(getMatch_id(), that.getMatch_id());
    }


}
