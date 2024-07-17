package com.jwinton.auth.application.constants;

public enum ErrorCode {
    USER_EXISTS(1001, "User already exists"),
    USERNAME_INVALID(1002, "Username is invalid"),
    PASSWORD_INVALID(1003, "Password is invalid"),
    UNCATEGORIZED(9999, "Uncategorized error"),

    ;
    private int code;
    private String message;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
