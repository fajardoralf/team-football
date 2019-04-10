package com.norofff.team1.footballapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "contact")
public class Contact {
    @Id
    private int contact_id;
    private String contact_type;
    private String contact_detail;
    private int person_id;

    public Contact() {

    }

    public Contact(int contact_id, String contact_type, String contact_detail, int person_id) {
        this.contact_id = contact_id;
        this.contact_type = contact_type;
        this.contact_detail = contact_detail;
        this.person_id = person_id;
    }
}
