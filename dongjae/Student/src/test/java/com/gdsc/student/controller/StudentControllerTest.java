package com.gdsc.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdsc.student.domain.Student;
import com.gdsc.student.dto.StudentSaveRequestDto;
import com.gdsc.student.dto.StudentUpdateRequestDto;
import com.gdsc.student.repository.MemoryStudentRepository;
import com.gdsc.student.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

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
    @DisplayName("학생을 정상 저장한다")
    public void saveStudent() throws Exception {
        // given
        StudentSaveRequestDto requestDto = StudentSaveRequestDto.builder()
                .studentId(201914089L)
                .name("오동재")
                .major("컴공")
                .build();

        String url = "http://localhost:"+ port + "/students";

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .content(asJsonString(requestDto))
                        .contentType("application/json"))
                .andReturn();

        // then
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

        List<Student> all = studentRepository.findAll();
        assertThat(all.get(0).getStudentId()).isEqualTo(201914089L);
        assertThat(all.get(0).getName()).isEqualTo("오동재");
        assertThat(all.get(0).getMajor()).isEqualTo("컴공");

    }

    @Test
    @DisplayName("학생을 정상 수정한다")
    public void updateStudent() throws Exception {
        // given
        Student savedStudent = studentRepository.save(Student.builder()
                        .id(1L)
                        .studentId(201914089L)
                        .name("오동재")
                        .major("소프")
                .build()
        );

        Long updateId = savedStudent.getId();
        String expectedName = "칠동재";
        String expectedMajor = "디컨";

        StudentUpdateRequestDto requestDto = StudentUpdateRequestDto.builder()
                .name(expectedName)
                .major(expectedMajor)
                .build();

        String url = "http://localhost:" + port + "/students/" + updateId;

        // when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch(url)
                .content(asJsonString(requestDto))
                .contentType("application/json"))
                .andReturn();

        // then
        assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

        List<Student> all = studentRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(expectedName);
        assertThat(all.get(0).getMajor()).isEqualTo(expectedMajor);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}