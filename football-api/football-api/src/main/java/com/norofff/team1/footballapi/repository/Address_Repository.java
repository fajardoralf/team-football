package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Address_Repository extends JpaRepository<Address, Integer> {
    List<Address> findAll();

    Address getOne(Integer integer);
    Address save(Address address);

    void deleteById(int id);

}
