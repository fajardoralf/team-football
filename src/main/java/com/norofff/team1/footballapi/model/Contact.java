package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;         //Primary Key
    private String contact_type;
    private String contact_detail;
    private int person_id;          //Foregin Key

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Person.class)
    @JoinColumn(name = "person_id", updatable = false, insertable = false)
    private Person person;

    public Contact() {

    }

    public Contact(int contact_id, String contact_type, String contact_detail, int person_id) {
        this.contact_id = contact_id;
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
        this.person_id = person_id;
    }

    //postman constructor
    public Contact(String contact_type, String contact_detail, int person_id) {
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
        this.person_id = person_id;
    }
}
