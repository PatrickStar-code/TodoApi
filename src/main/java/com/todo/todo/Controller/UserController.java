package com.todo.todo.Controller;

import com.todo.todo.Controller.Mapper.UserMapper;
import com.todo.todo.Controller.Responses.UserResponse;
import com.todo.todo.Model.UserEntity;
import com.todo.todo.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo_app/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserEntity> userResponse = userService.getUsers();
        List<UserResponse> toUserResponse = userResponse.stream().map(UserMapper::toUserResponse).toList();
        return ResponseEntity.ok(toUserResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        Optional<UserEntity> userResponse = userService.getUser(id);
        return userResponse.map(UserMapper::toUserResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {

        Optional<UserEntity> response = userService.getUser(id);

        if(response.isPresent()) userService.deleteUser(id);

        else return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();

    }
}
