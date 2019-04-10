package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.MatchPosition;
import com.norofff.team1.footballapi.model.MatchPositionId;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MatchPosition_Repository extends JpaRepository<MatchPosition, MatchPositionId> {
    List<MatchPosition> findAll();

    MatchPosition getOne(MatchPositionId id);
    //MatchPosition save(MatchPosition matachPosition);
    //void deleteById(int id);
}