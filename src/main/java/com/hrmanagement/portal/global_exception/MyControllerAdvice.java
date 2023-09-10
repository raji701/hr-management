package com.hrmanagement.portal.global_exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hrmanagement.portal.ResponseDto.ApiErrorResponse;
import com.hrmanagement.portal.customexception.InvalidPasswordException;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noElementFound(NoSuchElementException ex) {
		return new ResponseEntity<>("Element with ID  not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(404, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(404, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}

	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ApiErrorResponse> handleInvalidPasswordException(InvalidPasswordException ex)
	{
		ApiErrorResponse errorResponse = new ApiErrorResponse(401, ex.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	}
}
