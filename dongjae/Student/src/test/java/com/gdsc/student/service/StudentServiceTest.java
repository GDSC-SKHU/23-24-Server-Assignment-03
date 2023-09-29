package com.gdsc.student.service;

import com.gdsc.student.domain.Student;
import com.gdsc.student.dto.StudentSaveRequestDto;
import com.gdsc.student.dto.StudentUpdateRequestDto;
import com.gdsc.student.repository.MemoryStudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    StudentService studentService;
    MemoryStudentRepository studentRepository;

    @BeforeEach
    public void beforeEach() {
        studentRepository = new MemoryStudentRepository();
        studentService = new StudentService(studentRepository);
    }

    @AfterEach
    public void afterEach() {
        studentRepository.clearStore();
    }

    @Test
    @DisplayName("객체 생성시 id값이 1부터 오름차순으로 설정된다.")
    public void idCreatedAscending() {

        // given
        StudentSaveRequestDto requestDto1 = StudentSaveRequestDto.builder()
                .name("A")
                .build();

        StudentSaveRequestDto requestDto2 = StudentSaveRequestDto.builder()
                .name("B")
                .build();

        StudentSaveRequestDto requestDto3 = StudentSaveRequestDto.builder()
                .name("C")
                .build();

        // when
        studentService.saveStudent(requestDto1); // 첫 번째 객체
        studentService.saveStudent(requestDto2); // 두 번째 객체
        studentService.saveStudent(requestDto3); // 세 번째 객체

        // then
        assertThat("C").isEqualTo(studentService.findStudentById(3L).getName());

    }

    @Test
    @DisplayName("존재하지 않는 id로 조회하면 예외가 발생한다")
    public void idNotFound() throws Exception {

        // given
        Student student = Student.builder()
                .id(1L)
                .studentId(201914089L)
                .name("오동재")
                .major("소프")
                .build();

        studentRepository.save(student);

        // when
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> studentService.findStudentById(0L)
        );

        // then
        assertThat(e.getMessage()).isEqualTo("해당하는 학생이 없습니다. id = " + 0L);

    }

    @Test
    @DisplayName("수정해도 객체는 변하지 않는다")
    public void objectNeverChange() {

        // given
        Student studentA = Student.builder()
                .id(1L)
                .studentId(201914089L)
                .name("오동재")
                .major("소프")
                .build();

        studentRepository.save(studentA);

        // when
        StudentUpdateRequestDto requestDto = StudentUpdateRequestDto.builder()
                .name("칠동재")
                .major("디컨")
                .build();

        Student studentB = studentService.updateStudentById(1L, requestDto);

        // then
        assertThat(studentA).isSameAs(studentB);

    }

}