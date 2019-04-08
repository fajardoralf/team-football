package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "match_position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchPosition {
    private String position;
    private int player_id;
    private int match_id;

    public MatchPosition(){}
}
