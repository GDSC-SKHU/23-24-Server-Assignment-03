package com.gdsc.student.repository;

import com.gdsc.student.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student updateById(Student student);
    void deleteById(Long id);

}
