package com.norofff.team1.footballapi.model;

import lombok.Data;

@Data
public class Result {
    private int score;
    private String result;
    private int match_id;
    private int team_id;

    public Result(){}
}
