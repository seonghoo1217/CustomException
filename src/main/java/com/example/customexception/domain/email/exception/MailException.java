package com.example.customexception.domain.email.exception;


import com.example.customexception.global.exception.BaseException;
import com.example.customexception.global.exception.BaseExceptionType;

public class MailException extends BaseException {
    private BaseExceptionType exceptionType;


    public MailException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
