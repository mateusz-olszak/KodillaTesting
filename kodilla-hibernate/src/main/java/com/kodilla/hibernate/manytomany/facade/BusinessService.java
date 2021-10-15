package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    private CompanyDao companyDao;
    private EmployeeDao employeeDao;

    @Autowired
    public BusinessService(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> getCompaniesMatchingName(String name) {
        return companyDao.retrieveCompaniesWithGivenNameRegex(name);
    }

    public List<Employee> getEmployeesMatchingName(String name) {
        return employeeDao.retrieveEmployeesWithGivenRegex(name);
    }
}
