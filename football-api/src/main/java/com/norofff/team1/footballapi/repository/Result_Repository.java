package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Result_Repository extends JpaRepository<Result, Integer> {
        List<Result> findAll();
}
