package com.todo.todo.Controller.Mapper;

import com.todo.todo.Controller.Requests.UserRequest;
import com.todo.todo.Controller.Responses.UserResponse;
import com.todo.todo.Model.UserEntity;

public class UserMapper {

    public static UserResponse toUserResponse(UserEntity userEntity) {
        return UserResponse.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .build();
    }

    public static UserEntity toUserEntity(UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.username())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }
}
