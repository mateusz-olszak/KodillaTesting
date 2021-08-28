package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskFinancialDetailsTestSuite {

    @Autowired
    private TaskFinancialDetialsDao taskFinancialRepo;

    @Test
    void testFindByPaid(){
        TaskFinancialDetails taskFinancial = new TaskFinancialDetails(BigDecimal.valueOf(20),true);
        taskFinancialRepo.save(taskFinancial);
        int id = taskFinancial.getId();

        List<TaskFinancialDetails> tasks = taskFinancialRepo.findByPaid(true);

        assertTrue(tasks.get(0).isPaid());
        assertEquals(1,tasks.size());

        taskFinancialRepo.deleteById(id);
    }

    @Test
    void testDeleteAll(){
        taskFinancialRepo.deleteAll();
    }

}
