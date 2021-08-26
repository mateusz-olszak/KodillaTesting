package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.springframework.data.repository.CrudRepository;

public interface TaskFinancialDetialsDao extends CrudRepository<TaskFinancialDetails,Integer> {
}
