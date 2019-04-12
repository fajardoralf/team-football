package com.norofff.team1.footballapi.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "player")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int player_id;
    private String normal_position;
    private String number;
    private int person_id;
    private int team_id;


    @OneToMany
    @JoinColumn(name = "person_id")
    private List<Person> person;

    public Player() {
    }

    //Full Constructor
    public Player(int player_id, String normal_position, String number, int person_id, int team_id) {
        this.player_id = player_id;
        this.normal_position = normal_position;
        this.number = number;
        this.person_id = person_id;
        this.team_id = team_id;
    }
    //Postmann Constructor
    public Player(String normal_position, String number, int person_id, int team_id) {
        this.normal_position = normal_position;
        this.number = number;
        this.person_id = person_id;
        this.team_id = team_id;
    }
    //Constructor without normal_position (Can be Null)
    public Player(int player_id, String number, int person_id, int team_id) {
        this.player_id = player_id;
        this.number = number;
        this.person_id = person_id;
        this.team_id = team_id;
    }
    /*NEED BUG FIX!! TWO CONSTRUCTORS WITH THE SAME SIGNATURE!!
    //Constructor without number (can be Null)
    public Player(int player_id, String normal_position, int person_id, int team_id) {
        this.player_id = player_id;
        this.normal_position = normal_position;
        this.person_id = person_id;
        this.team_id = team_id;
    }*/

    //Constructor without normal_position or number (Can both be Null)
    public Player(int player_id, int person_id, int team_id) {
        this.player_id = player_id;
        this.person_id = person_id;
        this.team_id = team_id;
    }

}
