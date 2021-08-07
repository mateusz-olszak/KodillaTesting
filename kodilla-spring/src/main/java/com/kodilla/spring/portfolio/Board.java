package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList taskList) {
        if (taskList.getTasks().contains("Preparing project architecture"))
            this.toDoList = taskList;
        else if (taskList.getTasks().contains("Realizing the project"))
            this.inProgressList = taskList;
        else
            this.doneList = taskList;
    }

    @Override
    public String toString() {
        return "toDoList " + toDoList +
                ", inProgressList " + inProgressList +
                ", doneList " + doneList;
    }
}
