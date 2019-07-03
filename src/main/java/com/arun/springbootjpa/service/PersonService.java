package com.arun.springbootjpa.service;

import com.arun.springbootjpa.model.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    Person upsert(Person person);

    void delete(Long id);

    List<Person> getAllPerson();
}
