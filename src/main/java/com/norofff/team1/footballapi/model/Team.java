package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private int owner_id;
    private int association_id;
    private int coach_id;
    private int location_id;
    private String team_name;
    public Team(){}

    public Team(int team_id, int owner_id, int association_id, int coach_id, int location_id, String team_name) {
        this.team_id = team_id;
        this.owner_id = owner_id;
        this.association_id = association_id;
        this.coach_id = coach_id;
        this.location_id = location_id;
        this.team_name = team_name;
    }
    //Postmann constructor
    public Team(int owner_id, int association_id, int coach_id, int location_id, String team_name) {
        this.owner_id = owner_id;
        this.association_id = association_id;
        this.coach_id = coach_id;
        this.location_id = location_id;
        this.team_name = team_name;
    }
}
