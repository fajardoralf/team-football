package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "match_goal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_id;    //Primary key
    private String description; //Can be Null
    private int goal_type_id;   //Foreign key
    private int match_id;       //Foreign key
    private int player_id;      //Foreign key


    public MatchGoal () {}

    public MatchGoal(int goal_id, String description, int goal_type_id, int match_id, int player_id) {
        this.goal_id = goal_id;
        this.description = description;
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.player_id = player_id;
    }

    //Postmann Constructor
    public MatchGoal(int player_id, int goal_type_id, int match_id, String description) {
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.player_id = player_id;
        this.description = description;
    }

    //Without description --> can be Null
    public MatchGoal(int goal_id, int goal_type_id, int match_id, int player_id) {
        this.goal_id = goal_id;
        this.goal_type_id = goal_type_id;
        this.match_id = match_id;
        this.player_id = player_id;
    }
}
