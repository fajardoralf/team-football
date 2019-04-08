package com.norofff.team1.footballapi.model;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class MatchGoal {
    private int goal_id;    //Primary key
    @Nullable
    private String description;
    private int goal_type_id;   //Foreign key
    private int match_id;       //Foreign key
    private int player_id;      //Foreign key


    public MatchGoal () {}
}
