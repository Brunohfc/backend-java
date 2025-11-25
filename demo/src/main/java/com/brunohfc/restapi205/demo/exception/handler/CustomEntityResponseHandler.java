package com.brunohfc.restapi205.demo.exception.handler;

import com.brunohfc.restapi205.demo.exception.ExceptionResponse;
import com.brunohfc.restapi205.demo.exception.InvalidJWTAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidJWTAuthException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidJWTAuthException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(true)
        );

        return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
    }
}
