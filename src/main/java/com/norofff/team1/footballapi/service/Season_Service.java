package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Season;


import java.util.List;

public interface Season_Service {
    List<Season> findAll();

    Season getOne(int id);
    Season create(Season season);
    Season update(int id, Season season);
    void delete(int id);
}

