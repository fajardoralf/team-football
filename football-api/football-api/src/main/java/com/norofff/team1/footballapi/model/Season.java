package com.norofff.team1.footballapi.model;

import lombok.Data;

@Data
public class Season {
    private int season_id;
    private int start_date;
    private int end_date;
    private String name;
    private String description;

    public Season(){}
}
