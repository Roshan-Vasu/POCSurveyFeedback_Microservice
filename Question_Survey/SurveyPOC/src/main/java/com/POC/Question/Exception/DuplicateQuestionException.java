package com.POC.Question.Exception;

public class DuplicateQuestionException extends RuntimeException {
	
	public DuplicateQuestionException(String message){
		super (message);
	}
}
