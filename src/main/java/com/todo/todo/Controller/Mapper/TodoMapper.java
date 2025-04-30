package com.todo.todo.Controller.Mapper;

import com.todo.todo.Controller.Responses.TodoResponse;
import com.todo.todo.Model.TodoEntity;
import com.todo.todo.Model.UserEntity;

public class TodoMapper {

    public static TodoResponse toTodoResponse(TodoEntity todoEntity) {

        Long userId = todoEntity.getUser().getId();

        return TodoResponse.builder()
                .id(todoEntity.getId())
                .title(todoEntity.getTitle())
                .status(todoEntity.getStatus())
                .date(todoEntity.getDate())
                .description(todoEntity.getDescription())
                .priority(todoEntity.getPriority())
                .category(todoEntity.getCategory())
                .start_date(todoEntity.getStart_date())
                .end_date(todoEntity.getEnd_date())
                .userId(userId)
                .build();
    }

    public static TodoEntity toTodoEntity(TodoResponse todoResponse) {
        return TodoEntity.builder()
                .title(todoResponse.title())
                .status(todoResponse.status())
                .date(todoResponse.date())
                .description(todoResponse.description())
                .priority(todoResponse.priority())
                .category(todoResponse.category())
                .start_date(todoResponse.start_date())
                .end_date(todoResponse.end_date())
                .build();
    }
}
