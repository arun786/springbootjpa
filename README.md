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


## Use of Native Query, Named Query etc


    package com.arun.springbootjpa.model;
    
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import lombok.Getter;
    import lombok.Setter;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;
    
    import javax.persistence.*;
    import java.time.LocalDateTime;
    
    @Entity
    @Getter
    @Setter
    @Table(name = "t_course")
    @NamedQuery(name = "get_all_course", query = "select c from Course c")
    public class Course {
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "c_name", nullable = false)
        private String name;
        @JsonIgnore
        @UpdateTimestamp
        private LocalDateTime updateTimeStamp;
        @JsonIgnore
        @Column(updatable = false)
        @CreationTimestamp
        private LocalDateTime createTimeStamp;
    }



    package com.arun.springbootjpa.dao;
    
    import com.arun.springbootjpa.model.Course;
    import org.springframework.stereotype.Repository;
    
    import javax.persistence.EntityManager;
    import javax.persistence.PersistenceContext;
    import javax.persistence.Query;
    import javax.persistence.TypedQuery;
    import java.util.List;
    
    @Repository
    public class CourseDAOImpl implements CourseDAO {
    
        @PersistenceContext
        private EntityManager entityManager;
    
    
        @Override
        public Course getCourseById(Long id) {
            return entityManager.find(Course.class, id);
        }
    
        @Override
        public List<Course> getAllCourse() {
            return entityManager.createNamedQuery("get_all_course").getResultList();
        }
    
        @Override
        public Course getCourseByIdUsingNamedQuery(Long id) {
            TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.id = :id", Course.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        }
    
        @Override
        public Course getCourseByIdUsingNativeQuery(Long id) {
    
            Query nativeQuery = entityManager.createNativeQuery("select * from t_course c where c.id = ?", Course.class);
            nativeQuery.setParameter(1, id);
            return (Course) nativeQuery.getResultList().get(0);
        }
    
        @Override
        public Course saveCourse(Course course) {
            return entityManager.merge(course);
        }
    
        @Override
        public Course updateCourse(Course course) {
            return entityManager.merge(course);
        }
    }
