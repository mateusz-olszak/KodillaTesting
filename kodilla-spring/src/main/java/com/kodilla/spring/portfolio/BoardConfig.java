package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard(){
        return new Board(getTasksToDo(), getTasksInProgress(), getDoneList());
    }

    @Bean
    public TaskList getTasksToDo(){
        return new TaskList("Preparing project architecture");
    }

    @Bean
    public TaskList getTasksInProgress(){
        return new TaskList("Realizing the project");
    }

    @Bean
    public TaskList getDoneList(){
        return new TaskList("Realised project");
    }

}
