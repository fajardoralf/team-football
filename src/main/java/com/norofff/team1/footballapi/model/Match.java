package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;   //Primary Key
    private Date match_date;
    private int season_id;      //Foreign key
    private int location_id;    //Foreign key
    private int home_team_id;   //Foreign key
    private int away_team_id;   //Foreign key

    public Match(){}

    public Match(int match_id, Date match_date, int season_id, int location_id, int home_team_id, int away_team_id) {
        this.match_id = match_id;
        this.match_date = match_date;
        this.season_id = season_id;
        this.location_id = location_id;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
    }
}
