package com.norofff.team1.footballapi.service.implementation;


import com.norofff.team1.footballapi.model.Association;
import com.norofff.team1.footballapi.repository.Association_Repository;
import com.norofff.team1.footballapi.service.Association_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Association_Implementation implements Association_Service {
    private final Association_Repository association_repository;

    @Autowired
    public Association_Implementation(Association_Repository association_repository){
        this.association_repository = association_repository;
    }

    public List<Association> findAll() {
        return association_repository.findAll();
    }
}
