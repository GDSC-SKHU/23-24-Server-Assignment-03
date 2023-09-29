package com.gdsc.student.dto;

import com.gdsc.student.domain.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StudentResponseDto {

    private Long id;
    private Long studentId;
    private String name;
    private String major;

    @Builder
    public StudentResponseDto(Student student) {
        this.id = student.getId();
        this.studentId = student.getStudentId();
        this.name = student.getName();
        this.major = student.getMajor();
    }

}
