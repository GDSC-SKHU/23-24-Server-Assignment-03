package com.example._03_restapi_.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter //getter 자동 생성
public class ToDoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ToDo 리스트 ID (자동 생성)
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
