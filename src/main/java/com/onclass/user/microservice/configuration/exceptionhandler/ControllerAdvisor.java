package com.onclass.user.microservice.configuration.exceptionhandler;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.DocumentAlreadyExistsException;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.EmailAlreadyExistsException;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.user.microservice.configuration.Constants;
import com.onclass.user.microservice.domain.exception.InvalidEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(
                Constants.NOT_FOUNT_EXCEPTION_MESSAGE,
                HttpStatus.NOT_FOUND.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(InvalidEmailException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidEmailException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.INVALID_EMAIL_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(DocumentAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleDocumentAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.DOCUMENT_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleEmailAlreadyExistsException() {
        return ResponseEntity.badRequest().body(new ExceptionResponse(
                Constants.EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE,
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now()
        ));
    }
}