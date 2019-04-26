package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "team")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int team_id;
    private int owner_id;
    private int coach_id;
    private int location_id;
    private String team_name;
    public Team(){}

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", updatable = false, insertable = false)
    private Owner owner;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Coach.class)
    @JoinColumn(name = "coach_id", updatable = false, insertable = false)
    private Coach coach;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Location.class)
    @JoinColumn(name = "location_id", updatable = false, insertable = false)
    private Location location;

    public Team(int team_id, int owner_id, int coach_id, int location_id, String team_name) {
        this.team_id = team_id;
        this.owner_id = owner_id;
        this.coach_id = coach_id;
        this.location_id = location_id;
        this.team_name = team_name;
    }
    //Postmann constructor
    public Team(int owner_id, int coach_id, int location_id, String team_name) {
        this.owner_id = owner_id;
        this.coach_id = coach_id;
        this.location_id = location_id;
        this.team_name = team_name;
    }
}
