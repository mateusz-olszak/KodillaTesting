package com.kodilla.patterns2.adapter.company.newhrsys;

import java.math.BigDecimal;
import java.util.List;

public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor theProccessor = new CompanySalaryProcessor();
        return theProccessor.calculateSalaries(employees);
    }
}
