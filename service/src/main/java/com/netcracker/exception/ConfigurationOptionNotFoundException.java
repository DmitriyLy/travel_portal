package com.netcracker.exception;

/**
 * Created by dima_2 on 05.02.2017.
 */
public class ConfigurationOptionNotFoundException extends RuntimeException {

    public ConfigurationOptionNotFoundException() {
        super();
    }

    public ConfigurationOptionNotFoundException(String message) {
        super(message);
    }

}
