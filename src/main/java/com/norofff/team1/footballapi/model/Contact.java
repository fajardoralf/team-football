package com.norofff.team1.footballapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;         //Primary Key
    private String contact_type;
    private String contact_detail;
    private int person_id;          //Foregin Key

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
