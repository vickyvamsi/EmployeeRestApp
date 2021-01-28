package org.hcl.EmployeeRestApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.hcl.EmployeeRestApp.Exception.EmployeeMotFoundException;
import org.hcl.EmployeeRestApp.constant.EmployeeConstant;
import org.hcl.EmployeeRestApp.model.Employee;
import org.hcl.EmployeeRestApp.repository.EmployeeRepository;
import org.hcl.EmployeeRestApp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Long saveEmp(Employee employee) {
		return repo.save(employee).getEmpId();
	}

	@Override
	public void updateEmployee(Employee employee)throws EmployeeMotFoundException {

		if(repo.existsById(employee.getEmpId())) {
			repo.save(employee);
		}else {
			throw new EmployeeMotFoundException(EmployeeConstant.NO_DATA +" :"+employee.getEmpId());
		}
	}

	@Override
	public void deleteEmp(Long empId)throws EmployeeMotFoundException {
			
		Optional<Employee> emp=repo.findById(empId);
		if(emp.isPresent()) {
			repo.delete(getEmployeById(empId));
		}else {
			throw new EmployeeMotFoundException(EmployeeConstant.NO_DATA+ ":"+empId);
		}
	}

	@Override
	public Employee getEmployeById(Long empId) {
			
		return repo.findById(empId).orElseThrow(() -> new EmployeeMotFoundException(EmployeeConstant.NO_DATA));
	}

	@Override
	public List<Employee> getAllEmployes() {
		List<Employee> emps=repo.findAll();
		return emps;
	}

}
