package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "coach")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coach_id;   //Primary Key
    private Integer person_id;  //Foregin key

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    private Person person;

    public Coach(){}

    public Coach(int coach_id, int person_id) {
        this.coach_id = coach_id;
        this.person_id = person_id;
    }
    //Postman contructor
    public Coach(int person_id) {
        this.person_id = person_id;
    }
}
