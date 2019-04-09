package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Person;
import com.norofff.team1.footballapi.repository.Person_Repository;
import com.norofff.team1.footballapi.service.Person_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class Person_Implementation implements Person_Service {
    private final Person_Repository person_repository;

    @Autowired
    public Person_Implementation (Person_Repository person_repository) {
        this.person_repository = person_repository;
    }

    public List<Person> findAll() { return person_repository.findAll();}

    public Person getOne(int id) {return person_repository.getOne(id);}

    public Person create(Person person) {return person_repository.save(person);}

    public Person update(int id, Person person){
        person.setPerson_id(id);
        return person_repository.save(person);
    }

    public void delete(int id){
        try{
            person_repository.deleteById(id);

        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
