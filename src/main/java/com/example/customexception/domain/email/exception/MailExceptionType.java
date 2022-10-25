package com.example.customexception.domain.email.exception;

import com.example.customexception.global.exception.BaseExceptionType;
import org.springframework.http.HttpStatus;

public enum MailExceptionType implements BaseExceptionType {
    NOT_FOUND_EMAIL(701,HttpStatus.NOT_FOUND,"Email을 찾을 수 없습니다"),
    NO_VALUE_EMAIL_OR_NICKNAME(702,HttpStatus.BAD_REQUEST,"Email또는 NickName을 찾을 수 없습니다"),
    NO_VALIDATE_TOKEN(703,HttpStatus.FORBIDDEN,"서버에서 가지고있는 토큰과 다를 때 터짐"),
    NO_CREATE_EMAIL(704,HttpStatus.NOT_FOUND,"이메일 생성부분 에러");
    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;

    MailExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
