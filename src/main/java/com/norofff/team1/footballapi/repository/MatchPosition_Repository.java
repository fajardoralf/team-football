package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.MatchPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MatchPosition_Repository extends JpaRepository<MatchPosition, Integer> {
    List<MatchPosition> findAll();

    MatchPosition getOne(int id);
    MatchPosition save(MatchPosition matachPosition);
    void deleteById(int id);
}