package com.arun.springbootjpa.dao;

import com.arun.springbootjpa.model.Course;

import java.util.List;

public interface CourseDAO {

    Course getCourseById(Long id);

    List<Course> getAllCourse();

    Course getCourseByIdUsingNamedQuery(Long id);

    Course getCourseByIdUsingNativeQuery(Long id);

    Course saveCourse(Course course);

    Course updateCourse(Course course);
}
