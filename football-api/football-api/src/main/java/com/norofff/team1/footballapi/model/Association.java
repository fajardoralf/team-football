package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "association")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Association {
    @Id
    private int association;    //Primary Key
    private String name;
    private String description;

    public Association(){}
}
