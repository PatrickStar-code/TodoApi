package com.todo.todo.Service;

import aj.org.objectweb.asm.commons.Remapper;
import com.todo.todo.Model.UserEntity;
import com.todo.todo.Repository.TodoRepository;
import com.todo.todo.Model.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    public List<TodoEntity> getTodos() { return todoRepository.findAll();  }

    public Optional<TodoEntity> getTodo(Long id) { return todoRepository.findById(id); }

    public void deleteTodo(Long id) { todoRepository.deleteById(id);}

    public Optional updateTodo(Long id, TodoEntity todoEntity) {
        Optional<TodoEntity> response = todoRepository.findById(id);
        if(response.isPresent()) todoRepository.save(todoEntity);
        else return Optional.empty();
        return response;

    }

    public TodoEntity createTodo(TodoEntity todoEntity) {
        todoEntity.setUser(getUser(todoEntity.getUser().getId()));
        return todoRepository.save(todoEntity);
    }

    private UserEntity getUser(Long id) {
        return userService.getUser(id).get();
    }

}
