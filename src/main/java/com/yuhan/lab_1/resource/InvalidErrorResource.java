package com.yuhan.lab_1.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author yuhan
 * @date 10.10.2020 - 11:15
 * @purpose
 *
 * 信息封装
 */
public class InvalidErrorResource {
    private Integer code;
    private String message;
    private Object errors;


    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getErrors() {
        return errors;
    }

    public InvalidErrorResource() {
    }

    public InvalidErrorResource(String message,Integer code, Object errors) {
        this.message = message;
        this.code = code;
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "InvalidErrorResource{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
