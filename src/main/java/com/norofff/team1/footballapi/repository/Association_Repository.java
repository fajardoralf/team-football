package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Association_Repository extends JpaRepository<Association, Integer> {
    List<Association> findAll();

    Association getOne(Integer integer);
    Association save(Association association);

    void deleteById(int id);
}
