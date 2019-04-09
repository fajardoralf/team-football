package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Address;

import java.util.List;

public interface Address_Service {
    List<Address> findAll();

    Address getOne(int id);
    Address create(Address address);
    /*Address update(int id, Address address);*/
    boolean delete(int id);
}
