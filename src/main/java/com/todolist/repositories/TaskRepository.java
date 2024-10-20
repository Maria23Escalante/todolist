package com.todolist.repositories;

import com.todolist.model.Task;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
  List<Task> findByTitleContaining(String title);
}