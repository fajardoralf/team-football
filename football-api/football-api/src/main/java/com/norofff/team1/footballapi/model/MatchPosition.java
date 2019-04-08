package com.norofff.team1.footballapi.model;

import lombok.Data;

@Data
public class MatchPosition {
    private String position;
    private int player_id;
    private int match_id;

    public MatchPosition(){}
}
