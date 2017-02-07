package com.netcracker.exception;

/**
 * @author Oveian Egor
 */

public class NoSuchEntityException extends RuntimeException {
    public NoSuchEntityException (){
        super();
    }

    public NoSuchEntityException(String message) {
        super(message);
    }
}
