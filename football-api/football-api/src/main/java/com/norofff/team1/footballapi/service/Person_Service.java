package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Person_Service {
    List<Person> findAll();
}
