
package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "watchlist_player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WatchListPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int watchlist_player_id;
    private int user_id;
    private int player_id;

    public WatchListPlayer () {}

    public WatchListPlayer(int watchlist_player_id, int user_id, int player_id) {
        this.watchlist_player_id = watchlist_player_id;
        this.user_id = user_id;
        this.player_id = player_id;
    }

}
