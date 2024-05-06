package com.onclass.user.microservice.domain.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private EmailValidator() {
        throw new IllegalStateException("Utility class");
    }

    private static final String EMAIL_REGEX = "^[^@]+@[^@]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public static boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}