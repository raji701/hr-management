package com.hrmanagement.portal.customexception;
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String employeeId) {
        super(employeeId);
    }
}
