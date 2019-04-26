package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "result")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    private int score;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int result_id;
    private String result;
    private Integer match_id;   //Primary Key
    private int team_id;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Match.class)
    @JoinColumn(name = "match_id", updatable = false, insertable = false)
    private Match match;

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
