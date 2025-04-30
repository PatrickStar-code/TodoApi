package com.todo.todo.Controller.Responses;

import com.todo.todo.Enums.StatusEnum;
import com.todo.todo.Model.UserEntity;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TodoResponse(long id, String title, StatusEnum status, LocalDateTime date, String description, int priority, String category, LocalDateTime start_date, LocalDateTime end_date,
                           UserResponse user){

}

