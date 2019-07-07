package com.arun.springbootjpa.controller;

import com.arun.springbootjpa.model.Course;
import com.arun.springbootjpa.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @PostMapping("/courses/v1/course/{name}")
    public ResponseEntity<Course> save(@PathVariable String name) {
        Course course = new Course();
        course.setName(name);
        return ResponseEntity.ok().body(courseService.saveCourse(course));
    }

    @PutMapping("/courses/v1/course")
    public ResponseEntity<Course> update(@RequestBody Course course) {
        return ResponseEntity.ok().body(courseService.updateCourse(course));
    }

    @GetMapping("/courses/v1/course")
    public ResponseEntity<List<Course>> getAllCourse(){
        return ResponseEntity.ok().body(courseService.getAllCourse());
    }

    @GetMapping("/courses/v1/course/named/{id}")
    public ResponseEntity<Course> getCourseByIdUsingNamedQuery(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseByIdUsingNamedQuery(id));
    }


    @GetMapping("/courses/v1/course/native/{id}")
    public ResponseEntity<Course> getCourseByIdUsingNativeQuery(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseByIdUsingNativeQuery(id));
    }
}
