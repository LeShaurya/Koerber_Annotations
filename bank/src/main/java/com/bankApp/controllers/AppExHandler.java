package com.bankApp.controllers;

import com.bankApp.dto.ErrorMessages;
import com.bankApp.exception.AccountNotFoundException;
import com.bankApp.exception.InsufficientBalanceException;
import com.bankApp.exception.InvalidDepositException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessages> handleExceptionBadRequest(MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(" ,"));

        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(400).
                message(message)
                .toContact("ravi@abc.com")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorMessages> handleAccountNotFoundException(AccountNotFoundException ex) {
        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(404).
                message(ex.getMessage())
                .toContact("ravi@abc.com")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessages);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorMessages> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(400).
                message(ex.getMessage())
                .toContact("ravi@abc.com")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }

    @ExceptionHandler(InvalidDepositException.class)
    public ResponseEntity<ErrorMessages> handleInvalidDepositException(InvalidDepositException ex) {
        ErrorMessages errorMessages = ErrorMessages
                .builder().timestamp(LocalDateTime.now())
                .status(400).
                message(ex.getMessage())
                .toContact("ravi@abc.com")
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }
}


