package com.jason.springboot.domain;

public class GlobalResponse {
	
	private boolean error;
	
	private String message;
	
	private String origin;
	
	private String destination;
	
	public GlobalResponse() {
		
	}

	
	public GlobalResponse(boolean error, String message, String origin, String destination) {
		this.error = error;
		this.message = message;
		this.origin = origin;
		this.destination = destination;
	}


	public boolean isError() {
		return error;
	}


	public void setError(boolean error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
