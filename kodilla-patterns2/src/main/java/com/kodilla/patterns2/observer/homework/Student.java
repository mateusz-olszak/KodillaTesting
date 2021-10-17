package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Student implements HomeworkObservable {

    private final String name;
    private Queue<Task> tasks;
    private List<HomeworkObserver> mentors;

    public Student(String name) {
        this.name = name;
        tasks = new ArrayDeque<>();
        mentors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Queue<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void register(HomeworkObserver homeworkObserver) {
        mentors.add(homeworkObserver);
    }

    @Override
    public void notifyObservers() {
        for (HomeworkObserver mentor : mentors) {
            mentor.update(this);
        }
    }

    @Override
    public void unregister(HomeworkObserver homeworkObserver) {
        mentors.remove(homeworkObserver);
    }
}
