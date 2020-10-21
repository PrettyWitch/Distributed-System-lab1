package com.yuhan.lab_1.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuhan
 * @date 10.10.2020 - 11:13
 * @purpose
 *
 * 字段错误
 */
public class FieldResource {
    /**
     * 实体对象
     */
    private String resource;
    /**
     * 字段
     */
    private String field;
    /**
     * 代码
     */
    private String code;
    /**
     * 具体信息
     */
    private String message;

    public FieldResource() {
    }

    public FieldResource(String resource, String field, String code, String message) {
        this.resource = resource;
        this.field = field;
        this.code = code;
        this.message = message;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FieldResource{" +
                "resource='" + resource + '\'' +
                ", field='" + field + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
