package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "season")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Season {
    private int season_id;
    private int start_date;
    private int end_date;
    private String name;
    private String description;

    public Season(){}
}
