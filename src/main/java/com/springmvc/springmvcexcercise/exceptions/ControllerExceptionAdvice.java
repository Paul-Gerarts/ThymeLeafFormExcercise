package com.springmvc.springmvcexcercise.exceptions;

import com.springmvc.springmvcexcercise.entities.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiError> handleCustomException(CustomException exception) {
        if (exception.getHttpStatus().is5xxServerError()) {
            logger.error(exception, exception);
        } else {
            logger.warn(exception, exception);
        }

        return new ResponseEntity<>(
                ApiError.builder()
                        .title(exception.getLastName())
                        .status(exception.getHttpStatus().getReasonPhrase())
                        .code(exception.getHttpStatus().value())
                        .build(),
                exception.getHttpStatus()
        );
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
