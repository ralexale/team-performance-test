package com.riwi.performance.test.riwi_perfomance_test.api.error_handler;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.errors.BaseErrorsResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.errors.ErrorResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.errors.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseErrorsResponse handleJsonParseException(HttpMessageNotReadableException ex) {
        return ErrorResponse.builder()
                .message("Check your Json format. " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseErrorsResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        return ErrorResponse.builder()
                .message("Invalid value for enum: " + ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorsResponse handleErrors(MethodArgumentNotValidException exception) {
        List<String> errors = new ArrayList<>();

        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));

        return ErrorsResponse.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST.name())
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
