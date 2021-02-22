package com.zup.cqc.Exception;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
