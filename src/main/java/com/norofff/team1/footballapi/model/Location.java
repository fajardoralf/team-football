package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "location")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;    //Primary key
    private String name;
    private String address_id;  //Foreign key
    private String description; //Can be Null

    public Location(){}

    public Location(int location_id, String name, String address_id, String description) {
        this.location_id = location_id;
        this.name = name;
        this.address_id = address_id;
        this.description = description;
    }
    //Postmann Constructor
    public Location(String name, String address_id, String description) {
        this.name = name;
        this.address_id = address_id;
        this.description = description;
    }

    //Without description --> can be Null
    public Location(int location_id, String name, String address_id) {
        this.location_id = location_id;
        this.name = name;
        this.address_id = address_id;
    }
}
