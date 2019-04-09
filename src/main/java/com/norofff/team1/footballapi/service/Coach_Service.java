package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Coach;

import java.util.List;

public interface Coach_Service {
    List<Coach> findAll();

    Coach getOne(int id);
    Coach create(Coach association);
    Coach update(int id, Coach association);
    void delete(int id);
}
