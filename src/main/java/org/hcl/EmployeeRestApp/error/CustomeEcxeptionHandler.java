package org.hcl.EmployeeRestApp.error;

import org.hcl.EmployeeRestApp.Exception.EmployeeMotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomeEcxeptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeMotFoundException.class)
	public ResponseEntity<ErrorResponse> employeNotFoundHandler(EmployeeMotFoundException emperror){
		
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorCode("EMP-001");
		errorResponse.setMessage(emperror.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
