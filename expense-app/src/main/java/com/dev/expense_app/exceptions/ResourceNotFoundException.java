package com.dev.expense_app.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    /**
     * Serial Version Id
     */
    private static final long serialVersionUID =1L;

    public ResourceNotFoundException(String message){
        super(message);
    }
}
