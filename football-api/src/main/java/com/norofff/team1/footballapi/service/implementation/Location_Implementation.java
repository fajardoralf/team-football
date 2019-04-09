package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Location;
import com.norofff.team1.footballapi.repository.Location_Repository;
import com.norofff.team1.footballapi.service.Location_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Location_Implementation implements Location_Service {
    private final Location_Repository location_repository;
    @Autowired
    public Location_Implementation(Location_Repository location_repository){
        this.location_repository = location_repository;
    }

    public List<Location> findAll() {
        return location_repository.findAll();
    }

}
