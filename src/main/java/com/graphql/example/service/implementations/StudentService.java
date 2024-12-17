package com.graphql.example.service.implementations;

import com.graphql.example.entities.Student;
import com.graphql.example.persistence.IStudentDAO;
import com.graphql.example.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private final IStudentDAO studentDAO;

    public StudentService(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDAO.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentDAO.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDAO.deleteById(id);
    }
}
