package com.brunohfc.restapi205.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJWTAuthException extends AuthenticationException {

    public InvalidJWTAuthException(String message){
        super(message);
    }
}
