package com.ToDoListApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String creator;
    //private String status;


    //Constructors
    public Task(){}
    public Task(String title, String description, String creator){
        this.title = title;
        this.description = description;
        this.creator = creator;
    }


    //Getters & Setters

    //Get Id
    public Long getId() {
        return id;
    }
    //Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //Creator
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }


    //To String Function
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", creator=" + creator + "]";
    }





}
