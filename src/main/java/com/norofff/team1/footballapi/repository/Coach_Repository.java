package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Coach_Repository extends JpaRepository<Coach, Integer> {
    List<Coach> findAll();
    Coach save(Coach association);

    void deleteById(int id);
}
