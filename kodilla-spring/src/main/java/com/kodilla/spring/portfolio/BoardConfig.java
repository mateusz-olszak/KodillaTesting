package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    private TaskList toDoList;

    @Autowired
    @Qualifier("inProgressList")
    private TaskList inProgressList;

    @Autowired
    @Qualifier("doneList")
    private TaskList doneList;

    @Bean
    public Board getBoard(){
        return new Board(toDoList, inProgressList, doneList);
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
