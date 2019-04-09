package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Location_Repository extends JpaRepository<Location, Integer> {
    List<Location> findAll();
    Location save(Location location);

    void deleteById(int id);
}
