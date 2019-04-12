package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Result {
    private int score;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int result_id;
    private String result;
    private int match_id;   //Primary Key
    private int team_id;

    public Result(){}

    public Result(int result_id, int score, int match_id, int team_id, String result) {
        this.result_id= result_id;
        this.score = score;
        this.match_id = match_id;
        this.team_id = team_id;
        this.result = result;
    }

    //Postmann constructor
    public Result(int score, int match_id, int team_id, String result) {
        this.score = score;
        this.match_id = match_id;
        this.team_id = team_id;
        this.result = result;
    }
}
