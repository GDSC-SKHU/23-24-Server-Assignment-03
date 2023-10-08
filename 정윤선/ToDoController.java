package com.example._03_restapi_.Controller;

import com.example._03_restapi_.Domain.ToDo;
import com.example._03_restapi_.Dto.ToDoDTO;
import com.example._03_restapi_.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todos") //기본 URL 정의
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) { //ToDoController 생성자를 통해 ToDoService 주입
        this.toDoService = toDoService;
    }

    //ToDo 항목 생성 엔드포인트
    @PostMapping("/")
    public ToDoDTO createToDo(@RequestBody ToDoDTO toDoDTO) {
        //JSON(JavaScript Object Notation, 서버에서 클라이언트 데이터를 보낼 때 사용하는 양식)를 ToDoDTO로 변환
        ToDo toDo = convertToEntity(toDoDTO);
        //새로운 ToDo 생성
        ToDo createdToDo = toDoService.createToDo(toDo);
        // 생성된 ToDo를 ToDoDTO로 변환하여 반환
        return convertToDTO(createdToDo);
    }

    //특정 ID의 ToDo 조회 엔드포인트
    @GetMapping("/{id}")
    public ToDoDTO getToDoById(@PathVariable Long id) {
        // ToDoService를 통해 특정 ID의 ToDo를 조회
        ToDo toDo = toDoService.getToDoById(id);
        //조회한 ToDo를 ToDoDTO로 변환하여 반환합니다.
        return convertToDTO(toDo);
    }

    //특정 ID에 대한 ToDo 조회
    @GetMapping("/user/{userId}")
    public List<ToDoDTO> getAllToDosByUserId(@PathVariable Long userId) {
        //ToDoService를 통해 특정 사용자 ID에 해당하는 모든 ToDO를 조회
        List<ToDo> toDos = toDoService.getAllToDosByUserId(userId);
        //조회한 ToDO 목록을 ToDoDTO 리스트로 변환하여 반환
        return toDos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //특정 ID의 ToDO 수정
    @PatchMapping("/{id}")
    public ToDoDTO updateToDo(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        //JSON 형태의 데이터를 ToDoDTO로 반환
        ToDo toDo = convertToEntity(toDoDTO);
        //ToDo 수정
        ToDo updatedToDo = toDoService.updateToDo(id, toDo);
        //수정된 ToDo 반환
        return convertToDTO(updatedToDo);
    }

    //ToDo 삭제 엔드포인트
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDoById(@PathVariable Long id) {
        boolean deleted = toDoService.deleteToDoById(id);
        if (deleted) {
            return ResponseEntity.ok("ToDo 삭제 완료");
        } else {
            return ResponseEntity.notFound().build(); // 해당 ID의 ToDo가 없는 경우
        }
    }

    private ToDoDTO convertToDTO(ToDo toDo) {
        ToDoDTO toDoDTO = new ToDoDTO();
        toDoDTO.setId(toDo.getId());
        toDoDTO.setUserId(toDo.getUserId());
        toDoDTO.setTask(toDo.getTask());
        toDoDTO.setCompleted(toDo.isCompleted());
        return toDoDTO;
    }

    private ToDo convertToEntity(ToDoDTO toDoDTO) {
        ToDo toDo = new ToDo();
        toDo.setUserId(toDoDTO.getUserId());
        toDo.setTask(toDoDTO.getTask());
        toDo.setCompleted(toDoDTO.isCompleted());
        return toDo;
    }
}
