package com.todoapp.services;

import com.todoapp.model.Task;
import com.todoapp.repositories.TaskRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public Task createTask(Task task) {
    return taskRepository.save(task);
  }

  public Task updateTask(UUID id, Task taskDetails) {
    Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    task.setTitle(taskDetails.getTitle());
    task.setDescription(taskDetails.getDescription());
    task.setCompleted(taskDetails.isCompleted());
    return taskRepository.save(task);
  }

  public void deleteTask(UUID id) {
    taskRepository.deleteById(id);
  }

  public List<Task> searchTasks(String title) {
    return taskRepository.findByTitleContaining(title);
  }
}