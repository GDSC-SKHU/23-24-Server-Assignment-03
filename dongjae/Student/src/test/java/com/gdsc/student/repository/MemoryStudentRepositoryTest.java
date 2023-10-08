package com.gdsc.student.repository;

import com.gdsc.student.domain.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryStudentRepositoryTest {

    MemoryStudentRepository repository = new MemoryStudentRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    @DisplayName("store에 저장된 객체와 조회한 객체는 같은 객체이다")
    public void storedObjectUnique() {

        // given
        Student student = Student.builder()
                .id(1L)
                .studentId(201914089L)
                .name("오동재")
                .major("소프")
                .build();

        Student student1 = repository.save(student);

        // when
        Student student2 = repository.findById(1L).get();

        // then
        assertThat(student1).isSameAs(student2);

    }

}