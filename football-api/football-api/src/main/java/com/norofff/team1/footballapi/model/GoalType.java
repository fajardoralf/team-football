package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "goal_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GoalType {
    private int goal_type_id;
    private String type;

    public GoalType(){}

}
