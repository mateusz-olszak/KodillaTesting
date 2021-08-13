package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testCreateTasks(){
        TaskFactory taskFactory = new TaskFactory();

        Task taskShopping = taskFactory.makeTask(TaskFactory.SHOPPING);
        Task taskDriving = taskFactory.makeTask(TaskFactory.DRIVING);
        Task taskPainting = taskFactory.makeTask(TaskFactory.PAINTING);
        taskShopping.executeTask();

        assertEquals(true,taskShopping.isTaskExecuted());
        assertEquals("GoDriving",taskDriving.getTaskName());
        assertEquals("GoPainting",taskPainting.getTaskName());
    }

}
