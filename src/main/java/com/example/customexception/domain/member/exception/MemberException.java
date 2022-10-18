package com.example.customexception.domain.member.exception;


import com.example.customexception.global.exception.BaseException;
import com.example.customexception.global.exception.BaseExceptionType;

public class MemberException extends BaseException {
    private BaseExceptionType exceptionType;


    public MemberException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
