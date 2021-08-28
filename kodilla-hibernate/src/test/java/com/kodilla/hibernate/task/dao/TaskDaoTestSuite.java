package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskListDao taskListDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testGetAllUsers(){
        Task task = new Task(DESCRIPTION,7);

        taskDao.save(task);

        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        assertTrue(readTask.isPresent());

        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoFindByDuration(){
        Task task = new Task(DESCRIPTION,7);
        taskDao.save(task);
        int duration = task.getDuration();

        List<Task> readTasks = taskDao.findByDuration(duration);

//        assertEquals(1,readTasks.size());

        //Clean up
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails(){
        Task task = new Task(DESCRIPTION,30);
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(2000),true);
        task.setTaskFinancialDetails(taskFinancialDetails);

        taskDao.save(task);
        int id = task.getId();

        assertNotEquals(0, id);

         taskDao.deleteById(id);

    }

    @Test
    void testDeleteAll(){
        taskDao.deleteAll();
    }

}
