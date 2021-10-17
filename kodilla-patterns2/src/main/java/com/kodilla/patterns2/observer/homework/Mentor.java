package com.kodilla.patterns2.observer.homework;

import java.util.Optional;

public class Mentor implements HomeworkObserver {

    private String name;
    private int countTasks;

    public Mentor(String name) {
        this.name = name;
        this.countTasks = 0;
    }

    public int getCountTasks() {
        return countTasks;
    }

    @Override
    public void update(Student student) {
        countTasks++;
        Task task = student.getTasks().poll();
        System.out.println("Hey " + name + " there is a new task from: " + student.getName()
                        +  ", task is: " + Optional.ofNullable(task.getTopic()).orElse("task error"));
    }
}
