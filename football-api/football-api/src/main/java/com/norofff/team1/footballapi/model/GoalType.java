package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "goal_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GoalType {
    @Id
    private int goal_type_id;   //Primary Key
    private String type;

    public GoalType(){}

}
