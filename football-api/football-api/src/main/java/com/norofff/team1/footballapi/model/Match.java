package com.norofff.team1.footballapi.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Match {
    private int match_id;
    private Date match_date;
    private int season_id;
    private int location_id;
    private int home_team_id;
    private int away_team_id;

    public Match(){}
}
