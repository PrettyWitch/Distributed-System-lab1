package com.yuhan.lab_1.exception;

/**
 * 资源未找到异常
 *
 * @author yuhan
 * @date 10.10.2020 - 11:07
 * @purpose
 */
public class ResourceNoFoundException extends  RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public ResourceNoFoundException(String message, int code){
        //super(message)代表执行父类有参数构造方法
        super(message);
        this.code = code;
    }
}
