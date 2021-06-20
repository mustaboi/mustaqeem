package com.example.fitnessapp;

public class task {
    String task_name,description;

    public task(String task_name, String description) {
        this.task_name = task_name;
        this.description = description;
    }

    public task() {
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
