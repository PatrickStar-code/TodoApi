package com.todo.todo.Repository;

import com.todo.todo.Model.TodoEntity;
import com.todo.todo.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    @Query("SELECT t FROM TodoEntity t WHERE t.user.id = :userId")
    List<TodoEntity> findByUserId(@Param("userId") Long userId);
}
