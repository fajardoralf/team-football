package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {
    @Id
    private String address_id;
    private String address_line_1;
    private String address_line_2;
    private String postal_code;
    private String city;
    private String country;
    private String address_line_3;

    public Address(){

    }

}
