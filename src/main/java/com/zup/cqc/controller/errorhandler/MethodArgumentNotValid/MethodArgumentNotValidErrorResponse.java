package com.zup.cqc.controller.errorhandler.MethodArgumentNotValid;

public class MethodArgumentNotValidErrorResponse {
    private String message;

    public MethodArgumentNotValidErrorResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

