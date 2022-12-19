package com.example.spring.jpa.demo.exception;

public class NoDataExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataExistException(String message) {
		super(message);
	}
}
