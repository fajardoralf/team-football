package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
    private String address_line_1;
    private String postal_code;
    private String city;
    private String country;

    public Address(){

    }

    //NB: constructor for data population
    public Address(String address_line_1, String postal_code, String city, String country) {
        //this.address_id = address_id;
        this.address_line_1 = address_line_1;
        //this.address_line_2 = address_line_2;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
        //this.address_line_3 = address_line_3;
    }

    public Address(int address_id, String address_line_1, String postal_code, String city, String country) {
        this.address_id = address_id;
        this.address_line_1 = address_line_1;
        this.postal_code = postal_code;
        this.city = city;
        this.country = country;
    }
}
