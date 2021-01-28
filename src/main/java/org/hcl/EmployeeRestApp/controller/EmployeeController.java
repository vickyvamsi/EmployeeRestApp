package org.hcl.EmployeeRestApp.controller;

import java.util.List;

import org.hcl.EmployeeRestApp.constant.EmployeeConstant;
import org.hcl.EmployeeRestApp.model.Employee;
import org.hcl.EmployeeRestApp.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	public static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		ResponseEntity<String> resp=null;
		try {
			Long empId=service.saveEmp(employee);
				resp=new ResponseEntity<String>(EmployeeConstant.SUCESS_CREATE +" :"+empId,HttpStatus.CREATED);
				LOGGER.info("After Sucess Insert :"+resp);
		} catch (Exception ex) {
			ex.printStackTrace();
			resp=new ResponseEntity<String>(EmployeeConstant.CREATE_FAIL,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return resp;
	}
	
	
	@GetMapping("/AllEmployees")
	public ResponseEntity<?> fetchAllEmploayees(){
		ResponseEntity<?> resp=null;
		
		List<Employee> emps=service.getAllEmployes();
		
		if(!emps.isEmpty()) {
			resp=new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);
		}else {
			resp=new ResponseEntity<String>(EmployeeConstant.NO_DATA,HttpStatus.NOT_FOUND);
		}
		return resp;
	}
	
	@GetMapping("/findByEMployeeId/{empId}")
	public ResponseEntity<?> findEmployee(@PathVariable Long empId){
		ResponseEntity<?> resp=null;
	Employee emp=service.getEmployeById(empId);
	if(emp!=null || !emp.equals(null)) {
		resp=new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
		return resp;
	}
}
