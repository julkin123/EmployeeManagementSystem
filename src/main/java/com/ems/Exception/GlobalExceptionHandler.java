package com.ems.Exception;




import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ApiError>  employeeNotFoundException(){
		ApiError error=new ApiError(400, "Employee is not exist with given id", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
		
		
		
	}
	@ExceptionHandler(value = EmployeeAlreadyExistException.class)
	public ResponseEntity<ApiError> employeeExistException(){
		ApiError error=new ApiError(400, "Employee Already Exist", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
				
				
				
	}

}
