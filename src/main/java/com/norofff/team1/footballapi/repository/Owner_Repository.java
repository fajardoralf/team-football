package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Owner_Repository extends JpaRepository<Owner, Integer> {
    List<Owner> findAll();
}
