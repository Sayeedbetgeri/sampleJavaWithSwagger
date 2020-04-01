package com.hackaton.cbft.exceptions;

public class DestinationAccountNotFoundException extends RuntimeException {
	
	public DestinationAccountNotFoundException() {
		super("Destination Account Not Found");
	}

}
