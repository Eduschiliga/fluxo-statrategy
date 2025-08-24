package com.eduardo.fluxostatrategy.exception.handler;

import com.eduardo.fluxostatrategy.exception.customizadas.WebClientResponseException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({
            WebClientResponseException.class
    })
    public ResponseEntity<ApiError> handlerTokenJWTException(RuntimeException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handlerGenericException(Exception ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
