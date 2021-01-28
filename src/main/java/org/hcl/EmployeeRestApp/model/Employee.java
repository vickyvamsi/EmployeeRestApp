package org.hcl.EmployeeRestApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long empId;
	private String empName;
	private double empSal;
	private String gender;

}
