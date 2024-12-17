package com.graphql.example.service.implementations;

import com.graphql.example.entities.Course;
import com.graphql.example.persistence.ICourseDAO;
import com.graphql.example.service.ICourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    private final ICourseDAO courseDAO;

    public CourseService(ICourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseDAO.findAll();
    }

    @Override
    public void saveCourse(Course student) {
        courseDAO.save(student);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDAO.deleteById(id);
    }
}
