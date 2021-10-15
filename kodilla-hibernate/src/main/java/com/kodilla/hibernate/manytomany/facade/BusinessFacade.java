package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessFacade {

    private static Logger LOGGER = LoggerFactory.getLogger(BusinessFacade.class);
    private BusinessService businessService;

    @Autowired
    public BusinessFacade(BusinessService businessService) {
        this.businessService = businessService;
    }

    public void filterCompaniesAndEmployees(String companyName, String employeeName) {
        LOGGER.info("Preparing to filter companies and employees");
        boolean wasError = false;
        try {
            List<Employee> employees = businessService.getEmployeesMatchingName(employeeName);
            if (employees.size() == 0) {
                wasError = true;
                LOGGER.warn("Zero employees found");
            } else {
                LOGGER.info("Successfully filtered employees, found: " + employees.size());
            }
            List<Company> companies = businessService.getCompaniesMatchingName(companyName);
            if (companies.size() == 0) {
                wasError = true;
                LOGGER.warn("Zero companies found");
            } else {
                LOGGER.info("Successfully filtered companies, found: " + companies.size());
            }
        } finally {
            if (wasError) {
                LOGGER.error("Error occured when filtering");
                throw new BusinessFilterException(BusinessFilterException.ERR_FILTERING);
            }
        }
    }
}
