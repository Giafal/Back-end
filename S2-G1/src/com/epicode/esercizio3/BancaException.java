package com.epicode.esercizio3;

public class BancaException extends Exception{
	
	public String message;
	
	public BancaException(String message) {
		super(message);
		this.message = message;
	}
	
	public String toString() {
		return message;
	}

}
