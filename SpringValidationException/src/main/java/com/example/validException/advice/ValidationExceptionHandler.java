package com.example.validException.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.validException.exc.CustomerNotFoundException;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	  public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex){
		Map<String, String> errorMap= new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
		  
	  }
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CustomerNotFoundException.class)
	public Map<String, String> handleCustomerNotFoundException(CustomerNotFoundException ex){
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("ErrorMessage",ex.getMessage());
		return errorMap;
	}

}
