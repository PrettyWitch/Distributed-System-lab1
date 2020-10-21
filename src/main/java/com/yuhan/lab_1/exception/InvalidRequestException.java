package com.yuhan.lab_1.exception;

import org.springframework.validation.Errors;

/**
 * 请求参数异常
 *
 * @author yuhan
 * @date 10.10.2020 - 11:05
 * @purpose
 */
public class InvalidRequestException extends RuntimeException{

    private Errors errors;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public Errors getErrors() {
        return errors;
    }

    public InvalidRequestException(String message, Integer code, Errors errors){
        super(message);
        this.code = code;
        this.errors = errors;
    }

    public InvalidRequestException(Errors errors){
        this.errors = errors;
    }
}
