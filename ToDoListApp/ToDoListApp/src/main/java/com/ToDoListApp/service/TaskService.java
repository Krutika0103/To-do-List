package com.ToDoListApp.service;

import com.ToDoListApp.models.Task;

public interface TaskService {
    Iterable<Task> getAllTasks();
    Task getTaskById(Long id);
    Task saveTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
