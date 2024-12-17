package com.graphql.example.controller;

import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputStudent;
import com.graphql.example.service.ICourseService;
import com.graphql.example.service.IStudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLStudentController {

    private final IStudentService studentService;
    private final ICourseService courseService;

    public GraphQLStudentController(IStudentService studentService, ICourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id) {
        return studentService.getStudentById(Long.parseLong(id));
    }

    @QueryMapping
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @MutationMapping
    public Student createStudent(@Argument InputStudent inputStudent) {

        Student student = new Student();
                student.setName(inputStudent.getName());
                student.setLastName(inputStudent.getLastName());
                student.setAge(inputStudent.getAge());
                student.setCourse(courseService.getCourseById(Long.valueOf(inputStudent.getCourseId())));

        studentService.saveStudent(student);
        return student;
    }

    @MutationMapping(name = "deleteStudentById")
    public String deleteStudent(@Argument String studentId) {
        studentService.deleteStudent(Long.parseLong(studentId));
        return "Student deleted";
    }

}
