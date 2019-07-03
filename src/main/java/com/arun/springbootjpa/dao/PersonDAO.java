package com.arun.springbootjpa.dao;

import com.arun.springbootjpa.model.Person;

import java.util.List;

public interface PersonDAO {
    Person findById(Long id);

    Person upsert(Person person);

    void delete(Long id);

    List<Person> getAllPerson();

}
