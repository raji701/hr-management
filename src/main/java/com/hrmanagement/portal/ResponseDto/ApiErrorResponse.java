package com.hrmanagement.portal.ResponseDto;

import java.util.Map;

public class ApiErrorResponse {
    private int code;
    private String message;
    private Map<String, Object> details;

    public ApiErrorResponse() {
    }

    public ApiErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
