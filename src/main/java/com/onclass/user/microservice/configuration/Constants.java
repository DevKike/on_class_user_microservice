package com.onclass.user.microservice.configuration;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String NOT_FOUNT_EXCEPTION_MESSAGE = "Recourse not found";
    public static final String INVALID_EMAIL_EXCEPTION_MESSAGE = "Invalid email address";
    public static final String DOCUMENT_ALREADY_EXISTS_EXCEPTION_MESSAGE = "Document already exists";
    public static final String EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE = "Email already exists";
    public static final String ALL_FIELDS_ARE_REQUIRED_EXCEPTION_MESSAGE = "All fields are required";
}