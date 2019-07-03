package com.arun.springbootjpa.service;

import com.arun.springbootjpa.dao.PersonDAO;
import com.arun.springbootjpa.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public Person findById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public Person upsert(Person person) {
        return personDAO.upsert(person);
    }

    @Override
    public void delete(Long id) {
        personDAO.delete(id);
    }

    @Override
    public List<Person> getAllPerson() {
        return personDAO.getAllPerson();
    }
}
