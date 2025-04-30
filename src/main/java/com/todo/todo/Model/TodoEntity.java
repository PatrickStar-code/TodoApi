package com.todo.todo.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.todo.todo.Enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_todo")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "status", nullable = false)
    private StatusEnum status;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "priority", nullable = false)
    private int priority;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime start_date;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime end_date;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
