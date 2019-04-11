package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "season")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int season_id;
    private int start_date;
    private int end_date;
    private String name;
    private String description;

    public Season(){}

    public Season(int season_id, int start_date, int end_date, String name, String description) {
        this.season_id = season_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
    }
    //Postmann constructor
    public Season(int start_date, int end_date, String name, String description) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
        this.description = description;
    }
    //Without description (Can be Null)
    public Season(int season_id, int start_date, int end_date, String name) {
        this.season_id = season_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.name = name;
    }
}
