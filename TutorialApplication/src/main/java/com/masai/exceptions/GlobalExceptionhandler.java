package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionhandler {
	
	
	@ExceptionHandler(TutorialException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler(TutorialException ie, WebRequest wr)  {
		System.out.println("inside myHandler method...");
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(wr.getDescription(false));
		
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST );
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandler2(Exception ie,WebRequest wr)  {
		System.out.println("inside myHandler2 method...");
		
		MyErrorDetails err= new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(wr.getDescription(false));
		
		
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST );	
		
	
	}
	

}
