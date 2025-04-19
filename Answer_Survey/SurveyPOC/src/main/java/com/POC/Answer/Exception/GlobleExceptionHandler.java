package com.POC.Answer.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleQuestionNotFound(ResourceNotFoundException ex,WebRequest request){
		ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExternalServiceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateQuestion(ExternalServiceException ex, WebRequest request){
		ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false) );
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handlerGlobelException (MethodArgumentNotValidException ex, WebRequest request ){
		
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		ErrorResponse error = new ErrorResponse(new Date(), message,request.getDescription(false));
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
		
	}
	
}
