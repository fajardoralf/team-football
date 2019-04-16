package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Result;
import com.norofff.team1.footballapi.repository.Result_Repository;
import com.norofff.team1.footballapi.service.Result_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Result_Implementation implements Result_Service {
    private final Result_Repository result_repository;

    @Autowired
    public Result_Implementation(Result_Repository result_repository){
        this.result_repository = result_repository;
    }

    public List<Result> findAll() {
        return result_repository.findAll();
    }

    public Result getOne(int id) {return result_repository.getOne(id);}

    public Result create(Result result) {return result_repository.save(result);}

    public Result update(int id, Result result){
        result.setResult_id(id);
        return result_repository.save(result);
    }

    public void delete(int id){
        try{
            result_repository.deleteById(id);

        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }

    public List<Result> matchIdResult(int id){
        return result_repository.matchIdResult(id);
    }
}
