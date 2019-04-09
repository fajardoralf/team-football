package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "result")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result {
    private int score;
    @Id
    private int match_id;   //Primary Key
    private int team_id;

    public Result(){}
}
