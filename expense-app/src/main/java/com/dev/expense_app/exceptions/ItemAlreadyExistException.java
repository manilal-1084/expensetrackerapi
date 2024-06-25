package com.dev.expense_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ItemAlreadyExistException extends RuntimeException{

    /**
     * Serial Version Id
     */
    private static final long serialVersionUID =1L;

    public ItemAlreadyExistException(String message){
        super(message);
    }
}
