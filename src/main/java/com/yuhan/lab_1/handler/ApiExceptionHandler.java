package com.yuhan.lab_1.handler;

import com.yuhan.lab_1.exception.InvalidRequestException;
import com.yuhan.lab_1.exception.ResourceNoFoundException;
import com.yuhan.lab_1.resource.ErrorResource;
import com.yuhan.lab_1.resource.FieldResource;
import com.yuhan.lab_1.resource.InvalidErrorResource;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuhan
 * @date 10.10.2020 - 11:16
 * @purpose
 */
@RestControllerAdvice(basePackages = "com.yuhan.lab_1.controller")
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNoFoundException.class)
    public HttpEntity<?> handleNotFound(ResourceNoFoundException e){
        ErrorResource errorResource = new ErrorResource(e.getMessage(),e.getCode());
        logger.error(errorResource.toString());
        return new ResponseEntity<>(errorResource, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidRequestException.class)
    public HttpEntity<?> handleInvalidRequest(InvalidRequestException e){
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for(FieldError fieldError : fieldErrors){
            fieldResources.add(
                    new FieldResource(fieldError.getObjectName(),
                            fieldError.getField(),
                            fieldError.getCode(),
                            fieldError.getDefaultMessage())
            );
        }
        InvalidErrorResource invalidErrorResource = new InvalidErrorResource(e.getMessage(),e.getCode(),fieldResources);
        logger.error(invalidErrorResource.toString());
        return new ResponseEntity<>(invalidErrorResource,HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public HttpEntity<?> interalError(RuntimeException e){
        logger.error("500",e);
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<?> handleException(Exception e){
        logger.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
