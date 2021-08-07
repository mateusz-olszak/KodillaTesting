package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    private TaskList taskList;

    @Bean
    public Board getBoard(){
        return new Board(taskList,taskList,taskList);
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getTasksToDo(){
        taskList = new TaskList("Preparing project architecture");
        return taskList;
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getTasksInProgress(){
        taskList = new TaskList("Realizing the project");
        return taskList;
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList(){
        taskList = new TaskList("Realised project");
        return taskList;
    }

}
