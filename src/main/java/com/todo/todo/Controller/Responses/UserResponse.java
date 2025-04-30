package com.todo.todo.Controller.Responses;

import lombok.Builder;

import java.util.List;

@Builder
public record UserResponse(Long id, String username, String email) {
}
