package com.example.test.web;

public class CustomException extends RuntimeException{
    int Code;
    String message;

    public CustomException(int code, String message) {
        Code = code;
        this.message = message;
    }
}
