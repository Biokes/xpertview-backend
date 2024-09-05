package com.web.xpertview.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static com.web.xpertview.utils.ExceptionMessage.INVALID_DETAILS_PROVIDED;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class XpertviewAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> dataResourceExceptions(Exception error){
        return ResponseEntity.status(BAD_REQUEST).body(
                Map.of("error", error.getMessage(),"success",false));
    }
}

