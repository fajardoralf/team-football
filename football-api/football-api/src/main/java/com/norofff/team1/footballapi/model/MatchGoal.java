package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "match_goal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchGoal {
    @Id
    private int goal_id;    //Primary key
    private String description;
    private int goal_type_id;   //Foreign key
    private int match_id;       //Foreign key
    private int player_id;      //Foreign key


    public MatchGoal () {}
}
