package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Location;
import com.norofff.team1.footballapi.repository.Location_Repository;
import com.norofff.team1.footballapi.service.Location_Service;

import java.util.List;

public class Location_Implementation implements Location_Service {
    private final Location_Repository location_repository;

    public Location_Implementation(Location_Repository location_repository){
        this.location_repository = location_repository;
    }

    public List<Location> findAll() {
        return location_repository.findAll();
    }

}
