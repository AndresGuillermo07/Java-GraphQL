package com.graphql.example.persistence;

import com.graphql.example.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseDAO extends CrudRepository<Course, Long> {
}
