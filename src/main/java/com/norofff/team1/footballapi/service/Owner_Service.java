package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Owner;

import java.util.List;

public interface Owner_Service {
    List<Owner> findAll();

    Owner getOne(int id);
    Owner create(Owner owner);
    Owner update(int id, Owner owner);
    void delete(int id);
}
