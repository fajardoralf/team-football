package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Person_Repository extends JpaRepository<Person, Integer> {
    List<Person> findAll();

    Person getOne(Integer integer);
    Person save(Person person);

    void deleteById(int id);
}
