package com.brunohfc.restapi205.demo.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
