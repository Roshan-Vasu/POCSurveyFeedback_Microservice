package com.POC.User.Exception;

public class DuplicateResources extends RuntimeException {
	public DuplicateResources (String message) {
		super(message);
	}
}
