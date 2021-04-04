package com.concertapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
			WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(resourceNotFoundException.getMessage(),
				request.getDescription(false));

		return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
	}
}
