package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Result;


import java.util.List;

public interface Result_Service {
    List<Result> findAll();

    Result getOne(int id);
    Result create(Result result);
    Result update(int id, Result team);
    void delete(int id);

    Result matchIdResult(int id);
}
