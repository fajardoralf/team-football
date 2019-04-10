package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "coach")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coach_id;   //Primary Key
    private int person_id;  //Foregin key

    public Coach(){}

    public Coach(int coach_id, int person_id) {
        this.coach_id = coach_id;
        this.person_id = person_id;
    }
}
