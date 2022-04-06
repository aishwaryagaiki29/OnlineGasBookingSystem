package com.onlinegasbooking.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onlinegasbooking.exception.CustomerNotFoundException;
import com.onlinegasbooking.exception.CylinderNotFoundException;
import com.onlinegasbooking.exception.GasBookingIdNotFound;
import com.onlinegasbooking.exception.IdNotFoundException;
import com.onlinegasbooking.exception.SurrenderCylinderNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
	@ExceptionHandler(CylinderNotFoundException.class)
	public ResponseEntity<String> cylinderNotFoundExceptionHandler(CylinderNotFoundException ne){
		
		return new ResponseEntity<String>(ne.getMessage(),HttpStatus.BAD_REQUEST); 
	} 
	
	@ExceptionHandler(SurrenderCylinderNotFoundException.class)
	public ResponseEntity<String> SurrenderCylinderNotFoundExceptionHandler(SurrenderCylinderNotFoundException ne){
		
		return new ResponseEntity<String>(ne.getMessage(),HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFoundExceptionHandler(CustomerNotFoundException ne){
		
		return new ResponseEntity<String>(ne.getMessage(),HttpStatus.BAD_REQUEST); 
	} 
	
	@ExceptionHandler(GasBookingIdNotFound.class)
	public ResponseEntity<String> gasBookingIdNotFoundExceptionHandler(GasBookingIdNotFound ne){
		
		return new ResponseEntity<String>(ne.getMessage(),HttpStatus.BAD_REQUEST); 
	} 
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> idNotFoundExceptionHandler(IdNotFoundException ne){
		
		return new ResponseEntity<String>(ne.getMessage(),HttpStatus.BAD_REQUEST); 
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationsExceptions(MethodArgumentNotValidException e){
		Map<String,String> errors = new HashMap<String,String>();
		e.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMsg = error.getDefaultMessage();
			errors.put(fieldName, errorMsg);
		});
		return errors;
	}
}
