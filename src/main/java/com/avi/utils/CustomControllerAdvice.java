package com.avi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomControllerAdvice {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CUSTOM MESSAGE HERE")
    @ExceptionHandler(NoDataFoundException.class)
    public NoDataFoundException handleException() {
    	
    	System.out.println("custom exception ");
    	 NoDataFoundException error = new NoDataFoundException("no data found");
    	 error.setErroDescription("data not available");
    	return error;	
    }
}