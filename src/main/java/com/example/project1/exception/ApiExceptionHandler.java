package com.example.project1.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String EmptyResultDataAccessException(Exception e, WebRequest request) {
        return "Không tồn tại!";
    }
}
