package com.hrmanagement.portal.customexception;

public class ForbiddenException extends RuntimeException {
   

    public ForbiddenException(String message) {
        super(message);
    }
}
