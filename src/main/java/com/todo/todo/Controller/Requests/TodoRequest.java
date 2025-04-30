package com.todo.todo.Controller.Requests;

import com.todo.todo.Enums.StatusEnum;

import java.time.LocalDateTime;

public record TodoRequest(String title, StatusEnum status, LocalDateTime date, String description, int priority, String category, LocalDateTime start_date, LocalDateTime end_date,
                          Long user) {
}
