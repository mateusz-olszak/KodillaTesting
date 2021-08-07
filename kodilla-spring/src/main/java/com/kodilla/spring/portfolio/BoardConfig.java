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
    TaskList taskList;

    @Bean
    public Board getBoard(){
        return new Board(taskList);
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getTasksToDo(){
        return new TaskList("Preparing project architecture");
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getTasksInProgress(){
        return new TaskList("Realizing the project");
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList(){
        return new TaskList("Realised project");
    }

}