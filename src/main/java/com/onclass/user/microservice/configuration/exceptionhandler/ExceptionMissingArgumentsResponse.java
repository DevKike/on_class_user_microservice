package com.onclass.user.microservice.configuration.exceptionhandler;

import java.util.List;

public class ExceptionMissingArgumentsResponse {
    private final String message;
    private final List<String> errors;

    public ExceptionMissingArgumentsResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }
}