package com.norofff.team1.footballapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name = "match")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Match {
    @Id
    private int match_id;   //Primary Key
    private Date match_date;
    private int season_id;
    private int location_id;
    private int home_team_id;
    private int away_team_id;

    public Match(){}
}
