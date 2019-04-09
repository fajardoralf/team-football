package com.norofff.team1.footballapi.service;

import com.norofff.team1.footballapi.model.Contact;

import java.util.List;

public interface Contact_Service {
    List<Contact> findAll();

    Contact getOne(int id);
    Contact create(Contact contact);
    Contact update(int id, Contact contact);
    void delete(int id);
}
