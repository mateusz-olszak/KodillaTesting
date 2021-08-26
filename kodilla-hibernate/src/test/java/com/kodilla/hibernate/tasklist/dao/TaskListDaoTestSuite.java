package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "LEARN HIBERNATE";
    private static final String DESCRIPTION = "You'll learn hibernate";

    @Test
    void testFindByListName(){
        TaskList taskList = new TaskList(LISTNAME,DESCRIPTION);
        taskListDao.save(taskList);
        String name = taskList.getListName();

        List<TaskList> tasks = taskListDao.findByListName(name);

        assertEquals(1,tasks.size());

        taskListDao.deleteAll();
    }

}
