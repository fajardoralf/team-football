package com.norofff.team1.footballapi.service.implementation;

import com.norofff.team1.footballapi.model.Contact;
import com.norofff.team1.footballapi.repository.Contact_Repository;
import com.norofff.team1.footballapi.service.Contact_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Contact_Implementation implements Contact_Service {

    private final Contact_Repository contact_repository;

    @Autowired
    public Contact_Implementation(Contact_Repository contact_repository){
        this.contact_repository = contact_repository;
    }

    public List<Contact> findAll() {
        return contact_repository.findAll();
    }

    public Contact create(Contact coach) {return contact_repository.save(coach);}

    public Contact update(int id, Contact contact){
        contact.setContact_id(id);
        return contact_repository.save(contact);
    }

    public void delete(int id){
        try{
            contact_repository.deleteById(id);
        }catch (IllegalAccessError e){
            throw new IllegalAccessError();
        }
    }
}
