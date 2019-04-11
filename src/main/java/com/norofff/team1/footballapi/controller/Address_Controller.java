package com.norofff.team1.footballapi.controller;

import com.norofff.team1.footballapi.model.Address;
import com.norofff.team1.footballapi.service.Address_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class Address_Controller {
    private final Address_Service address_service;

    @Autowired
    public Address_Controller(Address_Service address_service){
        this.address_service = address_service;
    }


    @GetMapping("/address")
    public ResponseEntity<List<Address>> findAll() {
        try {
            List<Address> addresses = address_service.findAll();
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("address/{id}")
    public ResponseEntity<Address> getOne(@PathVariable int id){
        try{
            Address address = address_service.getOne(id);
            return new ResponseEntity<>(address, HttpStatus.OK);
        }catch(DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/address")
    public ResponseEntity<Address> create(@RequestBody Address address){
        try{
            address_service.create(address);
            return new ResponseEntity<>(address, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/address/list")
    public ResponseEntity<Address[]> create(@RequestBody Address[] addresses){
        try{
            for (int i = 0; i < addresses.length;i++) {
                address_service.create(addresses[i]);
            }
            return new ResponseEntity<Address[]>(addresses, HttpStatus.CREATED);
        }catch (DataAccessException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/address/{id}")
    public ResponseEntity<Address> update(@PathVariable int id, @RequestBody Address address){
        try{
            address_service.update(id, address);
            return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
        }catch (DataAccessException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/address/{id}")
    public void delete(@PathVariable int id){
        address_service.delete(id);
    }

    /*public void creaeAdress(){
        String adresses[][] =
                {{"P.O. Box 610, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 611, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 612, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 613, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 614, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 615, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 616, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 617, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 618, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 619, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 620, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 621, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"P.O. Box 622, 5347 Sed Street", "38220", "Huntsville", "United Kingdom"},
                        {"Fulham", "SW6", "London", "England"},
                        {"201 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"202 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"203 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"204 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"205 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"206 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"207 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"208 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"209 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"210 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"211 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"212 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"213 St. John’s Road", "50502", "London", "United Kingdom"},
                        {"Sir Matt Busby Way", "50509", "Greater Manchester", "United Kingdom"}};
        for (String a[]: adresses) {
            String temp_address1 = a[0];
            String temp_postalCode = a[1];
            String temp_city = a[2];
            String temp_country = a[3];
            Address address = new Address(temp_address1, temp_postalCode,temp_city,temp_country);
            create(address);
        }
    }*/
}
