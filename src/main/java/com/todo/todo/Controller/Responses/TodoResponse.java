package com.todo.todo.Controller.Responses;

import com.todo.todo.Enums.StatusEnum;
import com.todo.todo.Model.UserEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TodoResponse(
        @Schema(example = "1", description = "ID da tarefa")
        long id,

        @Schema(example = "Tarefa 1", description = "Título da tarefa")
        String title,

        @Schema(example = "Pendente", description = "Status da tarefa")
        StatusEnum status,

        @Schema(example = "2022-01-01T00:00:00", description = "Data da tarefa")
        LocalDateTime date,

        @Schema(example = "Descrinção da tarefa", description = "Descrição da tarefa")
        String description,

        @Schema(example = "1", description = "Prioridade da tarefa")
        int priority,

        @Schema(example = "Categoria da tarefa", description = "Categoria da tarefa")
        String    category,

        @Schema(example = "2022-01-01T00:00:00", description = "Data de inicio da tarefa")
        LocalDateTime start_date,

        @Schema(example = "2022-01-01T00:00:00", description = "Data de fim da tarefa")
        LocalDateTime end_date,

        @Schema(example = "1", description = "ID do usuário")
        UserResponse user
){

}

