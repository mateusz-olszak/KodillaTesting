package com.kodilla.patterns2.adapter.company.newhrsys;

import java.math.BigDecimal;
import java.util.List;

public interface SalaryProcessor {
    BigDecimal calculateSalaries(List<Employee> employees);
}
