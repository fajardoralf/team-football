package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int match_id;   //Primary Key
    private Date match_date;
    private Integer season_id;      //Foreign key
    private Integer location_id;    //Foreign key
    private Integer home_team_id;   //Foreign key
    private Integer away_team_id;   //Foreign key

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Team.class)
    @JoinColumn(name = "home_team_id", updatable = false, insertable = false)
    private Team home_team;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Team.class)
    @JoinColumn(name = "away_team_id", updatable = false, insertable = false)
    private Team away_team;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Location.class)
    @JoinColumn(name = "location_id", updatable = false, insertable = false)
    private Location location;

    public Match(){}

    public Match(int match_id, Date match_date, int season_id, int location_id, int home_team_id, int away_team_id) {
        this.match_id = match_id;
        this.match_date = match_date;
        this.season_id = season_id;
        this.location_id = location_id;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
    }
    //Postmann constructor
    public Match(Date match_date, int home_team_id, int away_team_id,  int season_id, int location_id) {
        this.match_date = match_date;
        this.home_team_id = home_team_id;
        this.away_team_id = away_team_id;
        this.season_id = season_id;
        this.location_id = location_id;
    }
}
