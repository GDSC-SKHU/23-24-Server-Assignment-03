package com.gdsc.student.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Student {

    private Long id;
    private Long studentId;
    private String name;
    private String major;

    @Builder
    public Student(Long id, Long studentId, String name, String major) {
        this.studentId = studentId;
        this.id = id;
        this.name = name;
        this.major = major;
    }

    /*
    * 기존에 존재하던 initId(Long id)는 객체별로 유일해야 하는 id 필드를 외부에서 변경할 수 있는 여지가
    * 존재했기 때문에 변경이 불가하도록 설계를 변경하였다.
    * 특히 HashMap에 저장할 때 key 값으로 객체의 id값을 사용하기 때문에 id값은 객체별로 유일해야 하고
    * 변경이 불가해야 한다.
    */

    public void update(String name, String major) {
        this.name = name;
        this.major = major;
    }

}
