package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "owner")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int owner_id;
    private int person_id;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    private Person person;

    public Owner(){}

    public Owner(int owner_id, int person_id) {
        this.owner_id = owner_id;
        this.person_id = person_id;
    }
    //Postmann Constructor
    public Owner(int person_id) {
        this.person_id = person_id;
    }
}
