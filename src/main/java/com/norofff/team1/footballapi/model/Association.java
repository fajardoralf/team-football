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
    private int association_id;    //Primary Key
    private String name;
    private String description;

    public Association(){}

    public Association(int association_id, String name, String description) {
        this.association_id = association_id;
        this.name = name;
        this.description = description;
    }
}
