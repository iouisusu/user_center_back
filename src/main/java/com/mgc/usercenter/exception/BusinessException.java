package com.mgc.usercenter.exception;

import com.mgc.usercenter.common.ErrorCode;

/**
 * @version 1.0
 * @Author YJH
 * @Date 2024/11/25 22:04
 * @注释 业务异常类
 * 作用：相对于java自带的异常多了字段。能够更加灵活的定义异常。
 */
public class BusinessException extends RuntimeException {

    private final int code;
    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }
}
