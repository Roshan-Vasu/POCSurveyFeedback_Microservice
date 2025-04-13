package com.POC.Question.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(QuestionNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleQuestionNotFound(QuestionNotFoundException ex,WebRequest request){
		ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateQuestionException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateQuestion(DuplicateQuestionException ex, WebRequest request){
		ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false) );
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handlerGlobelException (MethodArgumentNotValidException ex, WebRequest request ){
		
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		ErrorResponse error = new ErrorResponse(new Date(), message,request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
