package com.todo.todo.Service;

import com.todo.todo.Model.UserEntity;
import com.todo.todo.Repository.TodoRepository;
import com.todo.todo.Model.TodoEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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
        if(response.isPresent()) {
            TodoEntity todo = response.get();
            UserEntity user = this.getUser(todo.getUser());


            todo.setId(id);
            todo.setUser(user);
            todo.setStatus(todoEntity.getStatus());
            todo.setTitle(todoEntity.getTitle());
            todo.setDate(todoEntity.getDate());
            todo.setDescription(todoEntity.getDescription());
            todo.setPriority(todoEntity.getPriority());
            todo.setCategory(todoEntity.getCategory());
            todo.setStart_date(todoEntity.getStart_date());
            todo.setEnd_date(todoEntity.getEnd_date());

            todoRepository.save(todo);
        }
        else return Optional.empty();
        return response;

    }

    public TodoEntity createTodo(TodoEntity todoEntity) {
        UserEntity findedUser = this.getUser(todoEntity.getUser());
        todoEntity.setUser(findedUser);
        return todoRepository.save(todoEntity);
    }



    private UserEntity getUser(UserEntity user) {
        if (user == null) {
            throw new IllegalArgumentException("Usuário inválido ou não informado.");
        }

        return userService.getUser(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + user.getId()));
    }



}
