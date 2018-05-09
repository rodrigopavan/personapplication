package com.daitan.personapplication.controller;

import com.daitan.personapplication.model.Person;
import com.daitan.personapplication.repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;


    @RequestMapping( method = {RequestMethod.POST,RequestMethod.PUT})
    public ResponseEntity<Person> includeOrUpdate(@RequestBody Person person){
        Person personSaved = personDAO.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personSaved);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@RequestParam("id") Integer id){
        Optional<Person> person = personDAO.findById(id);
        if(!person.isPresent()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(person.get());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity removePerson(@RequestParam("id") Integer id){
        personDAO.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
