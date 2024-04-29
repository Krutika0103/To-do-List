package com.ToDoListApp.repositories;

import com.ToDoListApp.models.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public  interface TaskRepository  extends CrudRepository<Task, Long> {

}
