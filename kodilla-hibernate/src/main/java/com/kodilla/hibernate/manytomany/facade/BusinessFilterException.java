package com.kodilla.hibernate.manytomany.facade;

public class BusinessFilterException extends RuntimeException {

    public static final String ERR_EMPLOYEE_NOT_FOUND = "Could not find employee";
    public static final String ERR_COMPANY_NOT_FOUND = "Could not find company";
    public static final String ERR_FILTERING = "Could not complete filtering";

    public BusinessFilterException(String message) {
        super(message);
    }
}
