package com.example._03_restapi_.Service;

import com.example._03_restapi_.Domain.ToDo;
import com.example._03_restapi_.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo getToDoById(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public List<ToDo> getAllToDosByUserId(Long userId) {
        return toDoRepository.findByUserId(userId);
    }

    public ToDo updateToDo(Long id, ToDo updatedToDo) {
        ToDo existingToDo = toDoRepository.findById(id).orElse(null);
        if (existingToDo != null) {
            existingToDo.setTask(updatedToDo.getTask());
            existingToDo.setCompleted(updatedToDo.isCompleted());
            return toDoRepository.save(existingToDo);
        }
        return null;
    }

    public boolean deleteToDoById(Long id) {
        if (toDoRepository.existsById(id)) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
