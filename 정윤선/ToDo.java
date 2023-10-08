package com.example._03_restapi_.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter //Getter 자동 생성
@Entity
public class ToDo {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동 생성, 자동 증가
    private Long id; // ToDo 리스트 ID
    private Long userId; // 사용자 ID
    private String task; // 할 일
    private boolean completed; // 완료 여부

    //setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
