package com.graphql.example.service;

import com.graphql.example.entities.Student;

import java.util.List;

public interface IStudentService {

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    void saveStudent(Student student);

    void deleteStudent(Long id);

}
