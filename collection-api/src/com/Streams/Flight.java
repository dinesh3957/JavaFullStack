package com.Streams;

public class Flight {
	
	
	private int code ;
	private String carrire;
	private String source;
	private String destination;
	
	
	public Flight(){
		
	}
	public Flight(int code, String carrire, String source, String destination) {
		this.code = code;
		this.carrire = carrire;
		this.source = source;
		this.destination = destination;
	}

	public String toString() {
	    return "Flight [code=" + code +
	            ", carrier=" + carrire +
	            ", source=" + source +
	            ", destination=" + destination + "]";
	}
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getCarrire() {
		return carrire;
	}


	public void setCarrire(String carrire) {
		this.carrire = carrire;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}

	

}
