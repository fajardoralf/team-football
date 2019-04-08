package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "association")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Association {
    private int association;
    private String name;
    private String description;

    public Association(){}
}
