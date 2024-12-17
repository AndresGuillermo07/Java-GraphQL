package com.graphql.example.service;

import com.graphql.example.entities.Course;
import java.util.List;

public interface ICourseService {

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    void saveCourse(Course student);

    void deleteCourse(Long id);

}
