package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Location;

import java.util.List;

public interface Location_Service {
    List<Location> findAll();

    Location getOne(int id);
    Location create(Location location);
    Location update(int id, Location location);
    void delete(int id);
}
