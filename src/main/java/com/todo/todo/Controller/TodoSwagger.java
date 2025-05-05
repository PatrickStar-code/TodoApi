package com.todo.todo.Controller;

import com.todo.todo.Controller.Responses.TodoResponse;
import com.todo.todo.Model.TodoEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TodoSwagger {

    @GetMapping("/")
    @Operation(summary = "Listar todas as tarefas", description = "Retorna uma lista com todas as tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Sucesso ao obter a lista de tarefas",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class)))    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<List<TodoResponse>> getTodos();

    @GetMapping("/{id}")
    @Operation(summary = "Obter tarefa por ID", description = "Retorna uma tarefa específica com base no ID fornecido")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    public ResponseEntity<TodoResponse> getTodo(@Parameter(description = "ID da tarefa a ser buscada") @PathVariable("id") Long id);

    @Operation(summary = "Deletar tarefa", description = "Exclui uma tarefa com base no ID fornecido")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@Parameter(description = "ID da tarefa a ser deletada") @PathVariable("id") Long id);

    @Operation(summary = "Atualizar tarefa", description = "Atualiza uma tarefa existente com base no ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Tarefa não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> updateTodo(@Parameter(description = "ID da tarefa a ser atualizada") @PathVariable("id") Long id,
                                                  @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto com os dados atualizados da tarefa", required = true,
                                                          content = @Content(schema = @Schema(implementation = TodoEntity.class))) @RequestBody TodoEntity todoEntity);

    @Operation(summary = "Criar nova tarefa", description = "Cria uma nova tarefa com os dados fornecidos")
    @ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class)))
    @PostMapping("/")
    public ResponseEntity<TodoResponse> createTodo(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto com os dados da nova tarefa", required = true,
            content = @Content(schema = @Schema(implementation = TodoEntity.class))) @RequestBody TodoEntity todoEntity);


    @GetMapping("/userId/{userId}")
    @Operation(summary = "Listar todas as tarefas de um usuário", description = "Retorna uma lista com todas as tarefas cadastradas de um usuário")
    @ApiResponse(responseCode = "200", description = "Sucesso ao obter a lista de tarefas",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TodoResponse.class)))    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<List<TodoResponse>> getTodosByUserId(@Parameter(description = "ID do usuário") @PathVariable("userId") Long userId);

}
