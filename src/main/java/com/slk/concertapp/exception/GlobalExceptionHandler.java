package com.slk.concertapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
			WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(resourceNotFoundException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity handleInvalidInputException(InvalidInputException invalidInputException, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(invalidInputException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(TicketBlockedException.class)
	public ResponseEntity handleTicketBlockedException(TicketBlockedException blockedException, WebRequest request) {

		ExceptionDetails exceptionDetails = new ExceptionDetails(blockedException.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionDetails, HttpStatus.NOT_FOUND);
	}
}
