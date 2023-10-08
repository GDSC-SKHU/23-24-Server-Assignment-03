package com.example._03_restapi_.Repository;

import com.example._03_restapi_.Domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // JpaRepository 인터페이스를 상속받은 ToDoRepository 인터페이스
    //JpaRepository: Spring Data JPA에서 제공하는 JPA 구현을 위한 인터페이스. Create/Read/Update/Delete 쿼리를 수행
    List<ToDo> findByUserId(Long userId); //사용자 ID에 해당하는 모든 ToDo 항목을 데이터베이스에서 조회
}