package com.desafioapi.exception;

public class ApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public ApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
