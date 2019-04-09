package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Association;

import java.util.List;

public interface Association_Service {
    List<Association> findAll();

    Association create(Association association);
    Association update(int id, Association association);
    void delete(int id);
}
