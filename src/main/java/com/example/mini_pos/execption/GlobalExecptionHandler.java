package com.example.mini_pos.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExecptionHandler {
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleApiExecption(ApiException e) {
		ErrorResponse errorResponse = new ErrorResponse(e.getStatus(), e.getMessage());
		return ResponseEntity.status(e.getStatus()).body(errorResponse);
	}
}