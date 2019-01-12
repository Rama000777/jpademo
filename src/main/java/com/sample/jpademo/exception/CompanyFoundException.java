package com.sample.jpademo.exception;

public class CompanyFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CompanyFoundException(String message) {
        super(message);
    }

}
