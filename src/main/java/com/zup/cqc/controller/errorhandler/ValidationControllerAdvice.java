package com.zup.cqc.controller.errorhandler;

import com.zup.cqc.Exception.EntityNotFoundException;
import com.zup.cqc.controller.errorhandler.MethodArgumentNotValid.MethodArgumentNotValidError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public MethodArgumentNotValidError handlerValidationError(MethodArgumentNotValidException exception){
        MethodArgumentNotValidError validationError = new MethodArgumentNotValidError();
        validationError.buildError(exception);
        return validationError;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handlerEntityNotFound(EntityNotFoundException exception){
        return "";
    }
}
