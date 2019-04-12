package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Match_Repository extends JpaRepository<Match, Integer> {
    List<Match> findAll();
    Match getOne(Integer integer);
    Match save(Match match);

    void deleteById(int id);

    @Query(value = "SELECT team.team_name, result.result, result.score \n" +
            "FROM result\n" +
            "NATURAL JOIN team", nativeQuery = true)
    List<Object> findAllMatchesLimited();
}
