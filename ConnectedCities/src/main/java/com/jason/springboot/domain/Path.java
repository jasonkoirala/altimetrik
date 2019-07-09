package com.jason.springboot.domain;

public class Path {

	private String origin;
	
	private String destination;
	
	public Path() {
		
	}

	public Path(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
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

	@Override
	public String toString() {
		return "Path [origin=" + origin + ", destination=" + destination + "]";
	}
	
	
	
}
