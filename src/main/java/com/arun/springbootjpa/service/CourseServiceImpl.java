package com.arun.springbootjpa.service;

import com.arun.springbootjpa.dao.CourseDAO;
import com.arun.springbootjpa.model.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;


    @Override
    public Course getCourseById(Long id) {
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDAO.getAllCourse();
    }

    @Override
    public Course getCourseByIdUsingNamedQuery(Long id) {
        return courseDAO.getCourseByIdUsingNamedQuery(id);
    }

    @Override
    public Course getCourseByIdUsingNativeQuery(Long id) {
        return courseDAO.getCourseByIdUsingNativeQuery(id);
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        return courseDAO.saveCourse(course);
    }

    @Override
    @Transactional
    public Course updateCourse(Course course) {
        return courseDAO.updateCourse(course);
    }
}
