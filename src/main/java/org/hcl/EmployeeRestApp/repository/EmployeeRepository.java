package org.hcl.EmployeeRestApp.repository;

import org.hcl.EmployeeRestApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
