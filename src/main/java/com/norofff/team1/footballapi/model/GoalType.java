package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "goal_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GoalType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int goal_type_id;   //Primary Key
    private String type;

    public GoalType(){}

    public GoalType(int goal_type_id, String type) {
        this.goal_type_id = goal_type_id;
        this.type = type;
    }

    //postman constructor
    public GoalType(String type) {
        this.type = type;
    }
}
