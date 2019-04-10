package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="watchlist_team")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class WatchListTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int watchlist_team_id;
    private int user_id;
    private int team_id;

    WatchListTeam () {}

    public WatchListTeam(int watchlist_team_id, int user_id, int team_id) {
        this.watchlist_team_id = watchlist_team_id;
        this.user_id = user_id;
        this.team_id = team_id;
    }
}
