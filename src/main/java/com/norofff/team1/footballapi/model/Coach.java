package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "coach")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coach {
    @Id
    private int coach_id;
    private int person_id;

    public Coach(){}

    public Coach(int coach_id, int person_id) {
        this.coach_id = coach_id;
        this.person_id = person_id;
    }
}
