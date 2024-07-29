package com.riwi.performance.test.riwi_perfomance_test.api.error_handler;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.riwi.performance.test.riwi_perfomance_test.api.dto.errors.BaseErrorsResponse;
import com.riwi.performance.test.riwi_perfomance_test.api.dto.errors.ErrorResponse;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerController {
    @ExceptionHandler(CannotCreateTransactionException.class)
    public BaseErrorsResponse handleCannotCreateTransactionException(CannotCreateTransactionException ex) {
        return ErrorResponse.builder()
                .message("A transaction could not be opened for the database. Please try again later.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}