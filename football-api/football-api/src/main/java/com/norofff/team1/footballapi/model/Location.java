package com.norofff.team1.footballapi.model;

import lombok.Data;

@Data
public class Location {
    private int location_id;
    private String name;
    private String address_id;

    public Location(){}
}
