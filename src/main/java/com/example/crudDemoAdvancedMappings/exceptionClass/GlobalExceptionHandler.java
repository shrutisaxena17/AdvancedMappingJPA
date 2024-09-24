package com.example.crudDemoAdvancedMappings.exceptionClass;

import com.example.crudDemoAdvancedMappings.responseEntity.UserResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserIdNotFoundException.class)
    ResponseEntity<UserResponseEntity> handleException(UserIdNotFoundException exc){
        UserResponseEntity errorResponse = new UserResponseEntity();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
