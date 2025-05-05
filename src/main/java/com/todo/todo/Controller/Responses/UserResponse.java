package com.todo.todo.Controller.Responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record UserResponse(
        @Schema(example = "1", description = "ID do usuário")
        Long id,

        @Schema(example = "João Silva", description = "Nome do usuário")
        String username,

        @Schema(example = "joao.silva@example.com", description = "Email do usuário")
        String email
) {
}
