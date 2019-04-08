package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "team")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team {
    @Id
    private int team_id;
    private int owner_id;
    private int association_id;
    private int coach_id;
    private int location_id;

    public Team(){}
}
