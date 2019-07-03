package com.arun.springbootjpa.controller;

import com.arun.springbootjpa.model.Person;
import com.arun.springbootjpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/v1/person")
    ResponseEntity<Person> findById(Long id) {
        Person byId = personService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PutMapping("/persons/v1/person")
    ResponseEntity<Person> upsert(@RequestBody Person person) {
        Person upsert = personService.upsert(person);
        return ResponseEntity.ok().body(upsert);
    }

    @DeleteMapping("/persons/v1/person")
    ResponseEntity<HttpStatus> delete(@RequestParam Long id) {
        personService.delete(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @GetMapping("/persons/v1/person/getall")
    ResponseEntity<List<Person>> getAll() {
        List<Person> allPerson = personService.getAllPerson();
        return ResponseEntity.ok().body(allPerson);
    }
}
