package com.ups.retailstore.exceptionhandling.exceptions;

import com.ups.retailstore.exceptionhandling.APIBaseException;
import org.springframework.http.HttpStatus;

public class ConflictException extends APIBaseException {


    public ConflictException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
