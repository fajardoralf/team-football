package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Person_Repository extends JpaRepository<Person, Integer> {
    List<Person> findAll();

    Person getOne(Integer integer);
    Person save(Person person);

    void deleteById(int id);

    //get team name by personid
    @Query(value = "SELECT ps.person_id, ps.first_name, ps.last_name, t.team_name\n" +
            "FROM player p JOIN person ps ON p.person_id = ps.person_id\n" +
            "JOIN team t ON p.team_id = t.team_id\n" +
            "WHERE ps.person_id = ?", nativeQuery = true)
    Object getTeamByPersonId(int id);
}
