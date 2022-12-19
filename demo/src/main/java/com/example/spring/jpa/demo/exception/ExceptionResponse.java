package com.example.spring.jpa.demo.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
	
	private String message;
	private LocalDateTime timestamp;
	private List<String> errors;
	
	public ExceptionResponse(String message, LocalDateTime timestamp){
		this.message = message;
		this.timestamp = timestamp;
	}
}
