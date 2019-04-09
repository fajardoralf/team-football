package com.norofff.team1.footballapi.repository;

import com.norofff.team1.footballapi.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Contact_Repository extends JpaRepository<Contact, Integer> {
    List<Contact> findAll();

    Contact save(Contact association);

    void deleteById(int id);
}
