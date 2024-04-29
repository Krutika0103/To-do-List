package com.ToDoListApp.controllers;

import com.ToDoListApp.models.Task;
import com.ToDoListApp.repositories.TaskRepository;
import com.ToDoListApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Controller
public class TaskController {

    @Autowired
    TaskService taskService;

    //Getting The Home Page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index";
    }

    // Getting The New Task Page
    @GetMapping("/task/newTask")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "newTask";
    }

    // Saving The New Task and Going Back To The Home Page
    @PostMapping("/task/newTask/save")
    public String saveNewTask(Task task, Model model) {
        Task saveTask = taskService.saveTask(task);
        model.addAttribute("task", saveTask);
        return "redirect:/ ";
    }

    // Showing The Specific Task
    @GetMapping("/task/{id}")
    public String show(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "task";
        } else {
            // Handle task not found scenario
            return "error"; // Or any other appropriate view
        }
    }

    // Updating A Specific Task
    @GetMapping("/task/{id}/edit")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "edit";
        } else {
            // Handle task not found scenario
            return "error"; // Or any other appropriate view
        }
    }

    @PutMapping("/task/{id}/update")
    public String update(@PathVariable Long id, Task task, Model model) {
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            return "redirect:/task/" + updatedTask.getId();
        } else {
            // Handle task not found scenario
            return "error"; // Or any other appropriate view
        }
    }

    // Delete Task
    @DeleteMapping("/task/{id}/delete")
    public String delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

}
