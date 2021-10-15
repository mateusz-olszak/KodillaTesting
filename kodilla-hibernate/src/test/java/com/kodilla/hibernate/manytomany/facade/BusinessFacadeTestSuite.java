package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BusinessFacadeTestSuite {

    @Autowired
    private BusinessFacade businessFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testCompaniesAndEmployeesMatchingName(){
        // Given
        Company softHouse = new Company("softHouse");
        Company softerHouse = new Company("softerHouse");
        Employee johnSmith = new Employee("John","Smith");
        Employee lindaKovalsky = new Employee("Linda","Kovalsky");
        Employee robGryn = new Employee("Rob","Gryn");
        softHouse.getEmployees().add(johnSmith);
        softHouse.getEmployees().add(lindaKovalsky);
        softerHouse.getEmployees().add(robGryn);
        johnSmith.getCompanies().add(softerHouse);
        lindaKovalsky.getCompanies().add(softHouse);
        robGryn.getCompanies().add(softerHouse);
        companyDao.saveAll(Arrays.asList(softHouse, softerHouse));
        employeeDao.saveAll(Arrays.asList(johnSmith,lindaKovalsky,robGryn));

        // When Then
        String companyName = "soft";
        String employeeName = "rob";
        try {
            businessFacade.filterCompaniesAndEmployees(companyName, employeeName);
        } catch (BusinessFilterException e) {
            System.err.println("App Error");
        }
    }

    @Test
    void testCompaniesAndEmployeesNotMatchingName_throwsBusinessException() {
        // Given
        Company softHouse = new Company("softHouse");
        Company softerHouse = new Company("softerHouse");
        Employee johnSmith = new Employee("John","Smith");
        Employee lindaKovalsky = new Employee("Linda","Kovalsky");
        Employee robGryn = new Employee("Rob","Gryn");
        softHouse.getEmployees().add(johnSmith);
        softHouse.getEmployees().add(lindaKovalsky);
        softerHouse.getEmployees().add(robGryn);
        johnSmith.getCompanies().add(softerHouse);
        lindaKovalsky.getCompanies().add(softHouse);
        robGryn.getCompanies().add(softerHouse);
        companyDao.saveAll(Arrays.asList(softHouse, softerHouse));
        employeeDao.saveAll(Arrays.asList(johnSmith,lindaKovalsky,robGryn));

        // When Then
        String companyName = "wrong_CompanyName";
        String employeeName = "wrong_EmployeeName";
        assertThrows(BusinessFilterException.class, () -> businessFacade.filterCompaniesAndEmployees(companyName,employeeName));
    }

}
