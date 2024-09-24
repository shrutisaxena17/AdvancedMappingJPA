package com.example.crudDemoAdvancedMappings.exceptionClass;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(String message){
        super(message);
    }
}
