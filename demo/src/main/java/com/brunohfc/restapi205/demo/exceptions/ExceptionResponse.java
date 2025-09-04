package com.brunohfc.restapi205.demo.exceptions;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
