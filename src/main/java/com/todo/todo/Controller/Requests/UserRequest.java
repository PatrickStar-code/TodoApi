package com.todo.todo.Controller.Requests;

import lombok.Builder;

@Builder
public record UserRequest(
    String username,
    String email,
    String password
) {
}
