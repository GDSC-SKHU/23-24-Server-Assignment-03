package com.gdsc.student.service;

import com.gdsc.student.domain.Student;
import com.gdsc.student.dto.StudentResponseDto;
import com.gdsc.student.dto.StudentSaveRequestDto;
import com.gdsc.student.dto.StudentUpdateRequestDto;
import com.gdsc.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Service 클래스 또한 싱글톤 객체(유일함)를 생성하므로
    // sequence 필드를 service layer에 위치해도 무관하다. (즉 sequence도 유일)
    // 따라서 도메인 객체가 생성되는 service layer에서 객체별로 unique 해야 하는 id값을 지정해준다.
    private static Long sequence = 0L;

    public Student saveStudent(StudentSaveRequestDto requestDto) {
        Student student = Student.builder()
                .id(++sequence)
                .studentId(requestDto.getStudentId())
                .name(requestDto.getName())
                .major(requestDto.getMajor())
                .build();

        return studentRepository.save(student);
    }

    public StudentResponseDto findStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당하는 학생이 없습니다. id = " + id));

        return StudentResponseDto.builder()
                .student(student)
                .build();
    }

    public List<StudentResponseDto> findAllStudent() {
        return studentRepository.findAll().stream()
                .map(StudentResponseDto::new)
                .collect(Collectors.toList());
    }

    /*
    *  기존에 존재하던 update 로직은 존재하는 객체를 삭제하고(더 이상 참조하지 않고)
    *  같은 데이터를 가진 새로운 객체를 생성하는 방식을 활용하였다.
    *  이는 추후 프로젝트 규모가 커졌을 때 충분히 문제가 될 수 있는 요소이다.
    *  따라서 수정을 해도 참조하는 객체를 변경하지 않는 방식으로 설계를 변경하였다.
    */
    public Student updateStudentById(Long id, StudentUpdateRequestDto requestDto) {
        // 해당 id를 가지는 객체를 반환
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당하는 학생이 없습니다. id = " + id));

        // 해당 객체의 내용을 수정
        student.update(requestDto.getName(), requestDto.getMajor());

        // 변경된 내용을 DB에 반영
        return studentRepository.updateById(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
