# SpringBootJPA


# CRUD Operations using JPA


## Model

        package com.arun.springbootjpa.model;
        
        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        
        import javax.persistence.*;
        import java.time.LocalDate;
        
        @Entity
        @NoArgsConstructor
        @AllArgsConstructor
        @Getter
        @NamedQuery(name = "get_all_person", query = "select p from Person p")
        public class Person {
        
            @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
            private Long id;
            private String name;
            private String location;
            private LocalDate birthDate;
        }


## Crud Operations in DAO

        package com.arun.springbootjpa.dao;
        
        import com.arun.springbootjpa.model.Person;
        import org.springframework.stereotype.Repository;
        
        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.transaction.Transactional;
        import java.util.List;
        
        @Repository
        @Transactional
        public class PersonDAOImpl implements PersonDAO {
        
            @PersistenceContext
            private EntityManager entityManager;
        
        
            @Override
            public Person findById(Long id) {
                return entityManager.find(Person.class, id);
            }
        
            @Override
            public Person upsert(Person person) {
                return entityManager.merge(person);
            }
        
            @Override
            public void delete(Long id) {
                Person person = entityManager.find(Person.class, id);
                entityManager.remove(person);
            }
        
            @Override
            public List<Person> getAllPerson() {
                return entityManager.createNamedQuery("get_all_person", Person.class).getResultList();
            }
        
        
        }

