package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Team;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Team_Service {
    List<Team> findAll();
}
