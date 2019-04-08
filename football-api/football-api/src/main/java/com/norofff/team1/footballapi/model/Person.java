package com.noroff.team1.footballapi.models;

import java.sql.Date;

/*CREATE TABLE PERSON
(
  person_id INT NOT NULL,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  date_of_birth DATE NOT NULL,
  address_id VARCHAR(64),
  PRIMARY KEY (person_id),
  FOREIGN KEY (address_id) REFERENCES ADDRESS(address_id)
);*/

public class Person{
    private int person_id;  //Primary key
    @Nullable
    private int address_id; //Foreign key (can be Null)
    private String first_name;
    private String last_name;
    private Date date_of_birth;

    //Constructors
    //Default Constructor
    public Person() {};
    /*NOT REALLY NEEDED
    //NO address_id Constructor
    public Person(int person_id, String first_name, String last_name, Date date_of_birth) {
        this.person_id = person_id;
        this.address_id = Null;
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
    }*/

    //Getters
    public int getPerson_id() {
        return person_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    //Setters
    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
