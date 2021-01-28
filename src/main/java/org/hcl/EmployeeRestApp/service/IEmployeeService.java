package org.hcl.EmployeeRestApp.service;

import java.util.List;

import org.hcl.EmployeeRestApp.model.Employee;

public interface IEmployeeService {

	public Long saveEmp(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmp(Long empId);
	public Employee getEmployeById(Long empId);
	public List<Employee> getAllEmployes();
}
