package com.gdsc.student.repository;

import com.gdsc.student.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryStudentRepository implements StudentRepository {

    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Student save(Student student) {
        store.put(student.getId(), student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Student> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public Student updateById(Student student) {
        store.put(student.getId(), student);
        return store.get(student.getId());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    public void clearStore() {
        store.clear();
    }
}
