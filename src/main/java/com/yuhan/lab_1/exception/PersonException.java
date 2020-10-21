package com.yuhan.lab_1.exception;

import org.springframework.validation.Errors;

/**
 * @author yuhan
 * @date 10.10.2020 - 22:18
 * @purpose
 */
public class PersonException extends RuntimeException{
    private Errors errors;

    public Errors getErrors() {
        return errors;
    }

    public PersonException(String message,Errors errors){
        super(message);

        this.errors = errors;
    }

    public PersonException(Errors errors){
        this.errors = errors;
    }
}
