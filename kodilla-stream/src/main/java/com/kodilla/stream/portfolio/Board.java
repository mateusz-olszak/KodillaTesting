package com.kodilla.stream.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class Board {

    private final List<TaskList> taskLists = new ArrayList<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList){
        taskLists.add(taskList);
    }

    public void removeTaskList(TaskList taskList){
        taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "name=" + name + ",\n" +
                ", taskLists='" + taskLists + '\'' +
                '}';
    }
}
