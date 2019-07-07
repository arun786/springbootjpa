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
