package com.ToDoListApp.serviceImpl;

import com.ToDoListApp.models.Task;
import com.ToDoListApp.repositories.TaskRepository;
import com.ToDoListApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCreator(updatedTask.getCreator());
            return taskRepository.save(existingTask);
        }
        return null; // Or you can throw an exception indicating task not found
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
