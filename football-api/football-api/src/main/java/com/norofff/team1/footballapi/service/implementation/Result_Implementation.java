package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Result;
import com.norofff.team1.footballapi.repository.Result_Repository;
import com.norofff.team1.footballapi.service.Result_Service;

import java.util.List;

public class Result_Implementation implements Result_Service {
    private final Result_Repository result_repository;

    public Result_Implementation(Result_Repository result_repository){
        this.result_repository = result_repository;
    }

    public List<Result> findAll() {
        return result_repository.findAll();
    }
}