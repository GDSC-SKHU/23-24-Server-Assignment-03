package com.gdsc.student.controller;

import com.gdsc.student.dto.StudentResponseDto;
import com.gdsc.student.dto.StudentSaveRequestDto;
import com.gdsc.student.dto.StudentUpdateRequestDto;
import com.gdsc.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @PostMapping("students")
    public void save(@RequestBody StudentSaveRequestDto requestDto) {
        studentService.saveStudent(requestDto);
    }

    @GetMapping("students/{id}")
    public StudentResponseDto findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.findAllStudent();
    }

    @PatchMapping("students/{id}")
    public void updateStudentById(@PathVariable Long id, @RequestBody StudentUpdateRequestDto requestDto) {
        studentService.updateStudentById(id, requestDto);
    }

    @DeleteMapping("students/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
