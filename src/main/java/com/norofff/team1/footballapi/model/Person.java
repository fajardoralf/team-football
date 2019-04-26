package com.norofff.team1.footballapi.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", unique = true, nullable = false)
    private int person_id;  //Primary key
    private int address_id; //Foreign key (can be Null) NEED BUG FIX, FOREGIN KEY CAN NOT!! BE NULL
    private String first_name;
    private String last_name;
    private Date date_of_birth;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.LAZY, targetEntity = Address.class)
    @JoinColumn(name = "address_id", updatable = false, insertable = false)
    private Address address;

    //Default Constructor
    public Person() {}

    //Postmann Constructor
    public Person(int address_id, String first_name, String last_name, Date date_of_birth) {
        this.address_id = address_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
    }

    //Full Constructor
    public Person(int person_id, int address_id, String first_name, String last_name, Date date_of_birth) {
        this.person_id = person_id;
        this.address_id = address_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
    }
}
