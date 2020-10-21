package com.yuhan.lab_1.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuhan
 * @date 10.10.2020 - 11:12
 * @purpose
 *
 * 错误资源
 */
public class ErrorResource {
    private String message;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResource(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public ErrorResource() {
    }

    @Override
    public String toString() {
        return "ErrorResource{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
