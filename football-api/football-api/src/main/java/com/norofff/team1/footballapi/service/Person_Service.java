package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Person;


import java.util.List;

public interface Person_Service {
    List<Person> findAll();

    Person getOne(int id);
    Person create(Person person);

}
