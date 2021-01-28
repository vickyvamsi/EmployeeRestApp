package org.hcl.EmployeeRestApp.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ErrorResponse {

	private String errorCode;
	private String message;
	
}
