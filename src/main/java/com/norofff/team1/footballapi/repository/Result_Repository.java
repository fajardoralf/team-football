package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Result_Repository extends JpaRepository<Result, Integer> {
        List<Result> findAll();
        Result getOne(Integer integer);
        Result save(Result result);

        void deleteById(int id);

        @Query(value = "SELECT * FROM result WHERE result.match_id = ?1", nativeQuery = true)
        Result matchIdResult(int id);
}
