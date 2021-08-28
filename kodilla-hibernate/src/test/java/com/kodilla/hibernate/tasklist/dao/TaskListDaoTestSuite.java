package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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

    @Test
    void testTaskListDaoSaveWithTasks(){
        Task task1 = new Task("Test: Learn Hibernate",14);
        Task task2 = new Task("Test: Write entities",3);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(20),false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10),false);
        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo Tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        taskListDao.save(taskList);


        List<TaskList> taskLists = taskListDao.findByListName(LISTNAME);

//        assertEquals(4,taskLists.size());

//        taskListDao.deleteById(id);
    }

    @Test
    void testDeleteAll(){
        taskListDao.deleteAll();
    }

}
