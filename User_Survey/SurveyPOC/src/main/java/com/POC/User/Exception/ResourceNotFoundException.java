package com.POC.User.Exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException (String message) {
		super(message);
	}
}
