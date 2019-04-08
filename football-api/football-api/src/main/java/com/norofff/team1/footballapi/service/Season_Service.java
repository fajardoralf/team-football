package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Season;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Season_Service {
    List<Season> findAll();
}
