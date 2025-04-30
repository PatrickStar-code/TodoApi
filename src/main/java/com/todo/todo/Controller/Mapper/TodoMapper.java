package com.todo.todo.Controller.Mapper;

import com.todo.todo.Controller.Requests.TodoRequest;
import com.todo.todo.Controller.Responses.TodoResponse;
import com.todo.todo.Controller.Responses.UserResponse;
import com.todo.todo.Model.TodoEntity;
import com.todo.todo.Model.UserEntity;

public class TodoMapper {

    public static TodoResponse toTodoResponse(TodoEntity todoEntity) {

        UserEntity user = todoEntity.getUser();
        UserResponse userResponse = UserMapper.toUserResponse(user);


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
                .user(userResponse)
                .build();
    }

    public static TodoEntity toTodoEntity(TodoRequest todoRequest) {
        return TodoEntity.builder()
                .title(todoRequest.title())
                .status(todoRequest.status())
                .date(todoRequest.date())
                .description(todoRequest.description())
                .priority(todoRequest.priority())
                .category(todoRequest.category())
                .start_date(todoRequest.start_date())
                .end_date(todoRequest.end_date())
                .build();
    }
}
