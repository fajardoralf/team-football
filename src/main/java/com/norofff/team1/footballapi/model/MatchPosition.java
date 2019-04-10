package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "match_position")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatchPosition implements Serializable {
    @EmbeddedId
    MatchPositionId id;
    private String position;

    public MatchPosition(){}

    public MatchPosition(MatchPositionId matchPosId, String position) {
        this.id = matchPosId;
        this.position = position;
    }
}


