package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "result")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result {
    private int score;
    private String result;
    private int match_id;
    private int team_id;

    public Result(){}
}
