package com.todo.todo.Controller;

import com.todo.todo.Controller.Mapper.TodoMapper;
import com.todo.todo.Controller.Responses.TodoResponse;
import com.todo.todo.Model.TodoEntity;
import com.todo.todo.Model.UserEntity;
import com.todo.todo.Service.TodoService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/todo_app/todo")
@RequiredArgsConstructor
public class TodoController implements TodoSwagger {

    private final TodoService todoService;

    @Override
    public ResponseEntity<List<TodoResponse>> getTodos() {
        List<TodoEntity> todos = todoService.getTodos();
        Stream<TodoResponse> todoResponses = todos.stream().map(TodoMapper::toTodoResponse);
        return ResponseEntity.ok(todoResponses.toList());
    }

    @Override
    public ResponseEntity<TodoResponse> getTodo(Long id) {
        return todoService.getTodo(id)
                .map(TodoMapper::toTodoResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteTodo(Long id) {
        Optional<TodoEntity> response = todoService.getTodo(id);
        if(response.isPresent()) todoService.deleteTodo(id);
        else return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TodoResponse> updateTodo(Long id, TodoEntity todoEntity) {
        Optional<TodoEntity> response = todoService.updateTodo(id, todoEntity);
        return response.map(TodoMapper::toTodoResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());    }

    @Override
    public ResponseEntity<TodoResponse> createTodo(TodoEntity todoEntity) {
        TodoEntity todoCreated = todoService.createTodo(todoEntity);
        return ResponseEntity.ok(TodoMapper.toTodoResponse(todoCreated));
    }

    @Override
    public ResponseEntity<List<TodoResponse>> getTodosByUserId(Long userId) {

        Optional<List<TodoEntity>> todos = todoService.getTodosByUserId(userId);
        if(todos.isEmpty()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(todos.get().stream().map(TodoMapper::toTodoResponse).toList());
    }


}
