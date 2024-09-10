package com.example.mini_pos.execption;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExecptionHandler {
	// Handle custom API exceptions (like ResourceNotFoundException)
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException e, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(errorResponse);
	}

	// Handle validation errors (e.g., @Valid on request body)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	// Handle JSON parse errors or invalid enum values
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleJsonParseError(HttpMessageNotReadableException ex) {
		String message = "Invalid request body";

		Throwable cause = ex.getCause();
		if (cause instanceof InvalidFormatException) {
			InvalidFormatException invalidFormatException = (InvalidFormatException) cause;
			message = "Invalid value for field: " + invalidFormatException.getPathReference();
		}

		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, message);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}