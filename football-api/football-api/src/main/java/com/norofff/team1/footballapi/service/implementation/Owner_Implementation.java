package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Owner;
import com.norofff.team1.footballapi.repository.MatchPosition_Repository;
import com.norofff.team1.footballapi.repository.Owner_Repository;
import com.norofff.team1.footballapi.service.Owner_Service;

import java.util.List;

public class Owner_Implementation implements Owner_Service {
    private final Owner_Repository owner_repository;

    public Owner_Implementation(Owner_Repository owner_repository){
        this.owner_repository = owner_repository;
    }

    public List<Owner> findAll() {
        return owner_repository.findAll();
    }
}
