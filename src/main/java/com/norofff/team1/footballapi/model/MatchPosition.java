package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Data
@Entity
@Table(name = "match_position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchPosition {
    private String position;
    @EmbeddedId
    private MatchPositionId id;

    public MatchPosition(){}
}

@Data
@Embeddable
class MatchPositionId implements Serializable {
    private int player_id;
    private int match_id;
}

