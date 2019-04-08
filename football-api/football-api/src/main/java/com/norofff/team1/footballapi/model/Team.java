package com.norofff.team1.footballapi.model;

import lombok.Data;

@Data
public class Team {
    private int team_id;
    private int owner_id;
    private int association_id;
    private int coach_id;
    private int location_id;

    public Team(){}
}
