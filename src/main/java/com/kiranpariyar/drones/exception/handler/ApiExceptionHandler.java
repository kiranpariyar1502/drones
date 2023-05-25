package com.kiranpariyar.drones.exception.handler;


import com.kiranpariyar.drones.exception.DroneApiParameterException;
import com.kiranpariyar.drones.exception.EntityNotFoundException;
import com.kiranpariyar.drones.response.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(
            RuntimeException ex) {
        ApiResponse<String> apiResponse = ApiResponse.clientError(ex.getMessage()).build();
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DroneApiParameterException.class)
    public ResponseEntity<Object> handleApiException(
            RuntimeException ex) {
        ApiResponse<String> apiResponse = ApiResponse.clientError(ex.getMessage()).build();
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
        ApiResponse<String> apiResponse = ApiResponse.clientError(String.join(",", errors)).build();
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}

