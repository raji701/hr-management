package com.hrmanagement.portal.global_exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hrmanagement.portal.ResponseDto.ApiErrorResponse;
import com.hrmanagement.portal.ResponseDto.ApiResponse;
import com.hrmanagement.portal.customexception.ResourceNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noElementFound(NoSuchElementException ex) {
		return new ResponseEntity<>("Element with ID  not found", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(404, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(errorResponse));
	}

}
