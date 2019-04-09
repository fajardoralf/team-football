package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Address;
import com.norofff.team1.footballapi.repository.Address_Repository;
import com.norofff.team1.footballapi.service.Address_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class Address_Implementation implements Address_Service {

    private final Address_Repository address_repository;

    @Autowired
    public Address_Implementation(Address_Repository address_repository) {
        this.address_repository = address_repository;
    }

    public List<Address> findAll() {
        return address_repository.findAll();
    }

    public Address getOne(int id) {return address_repository.getOne(id);}


    public Address create(Address address) {return address_repository.save(address);}

    /*public Address update(int id, Address address){
        address.setAddress_id(id);
        return address_repository.save(address);
    }*/

    public boolean delete(int id){
        try{
            address_repository.deleteById(id);
            return true;
        }catch (DataAccessException e){
            return false;
        }
    }
}
