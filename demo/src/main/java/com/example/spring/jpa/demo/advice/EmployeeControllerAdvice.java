package com.example.spring.jpa.demo.advice;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.spring.jpa.demo.exception.ExceptionResponse;
import com.example.spring.jpa.demo.exception.NoDataExistException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		final var errors = ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).filter(Objects::nonNull).toList();
		return new ResponseEntity<>(new ExceptionResponse("Validation Error", LocalDateTime.now(), errors),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoDataExistException.class)
	public ResponseEntity<ExceptionResponse> handleNoDataExistError(NoDataExistException exception) {
		return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), LocalDateTime.now(), null),
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<ExceptionResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		return new ResponseEntity<>(new ExceptionResponse(e.getLocalizedMessage(), LocalDateTime.now()),
				HttpStatus.BAD_REQUEST);
	}
}
