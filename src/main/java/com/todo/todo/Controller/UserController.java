package com.todo.todo.Controller;

import com.todo.todo.Controller.Mapper.UserMapper;
import com.todo.todo.Controller.Requests.UserRequest;
import com.todo.todo.Controller.Responses.UserResponse;
import com.todo.todo.Model.UserEntity;
import com.todo.todo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todo_app/users")
public class UserController implements UserSwagger {

    private final UserService userService;

    @Override
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserEntity> userResponse = userService.getUsers();
        List<UserResponse> toUserResponse = userResponse.stream().map(UserMapper::toUserResponse).toList();
        return ResponseEntity.ok(toUserResponse);    }

    @Override
    public ResponseEntity<UserResponse> getUser(Long id) {
        Optional<UserEntity> userResponse = userService.getUser(id);
        return userResponse.map(UserMapper::toUserResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        Optional<UserEntity> response = userService.getUser(id);
        if(response.isPresent()) userService.deleteUser(id);
        else return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.toUserEntity(userRequest);
        UserEntity userCreated = userService.createUser(userEntity);
        return ResponseEntity.ok(UserMapper.toUserResponse(userCreated));    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UserRequest userRequest) {
        UserEntity userEntity = UserMapper.toUserEntity(userRequest);
        Optional<UserEntity> response = userService.updateUser(id, userEntity);
        return response.map(UserMapper::toUserResponse).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
