package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.graphql.InputCourse;
import com.graphql.example.service.ICourseService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

    private final ICourseService courseService;

    public GraphQLCourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @QueryMapping(name = "findCourseById")
    public Course getById(@Argument String courseId) {
        return courseService.getCourseById(Long.parseLong(courseId));
    }

    @QueryMapping
    public List<Course> findAllCourses() {
        return courseService.getAllCourses();
    }

    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse) {
        Course course = new Course();
        course.setName(inputCourse.getName());
        course.setCategory(inputCourse.getCategory());
        course.setTeacher(inputCourse.getTeacher());

        courseService.saveCourse(course);
        return course;
    }

    @MutationMapping
    public String deleteCourseById(@Argument String courseId) {
        courseService.deleteCourse(Long.parseLong(courseId));
        return "course deleted successfully";
    }

}
