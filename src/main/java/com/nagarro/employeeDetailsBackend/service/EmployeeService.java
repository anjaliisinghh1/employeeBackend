package com.nagarro.employeeDetailsBackend.service;

import java.util.List;

import com.nagarro.employeeDetailsBackend.entity.EmployeeEntity;

public interface EmployeeService {
	List<EmployeeEntity> getAllEmployees();
	EmployeeEntity saveEmployee(EmployeeEntity employee);
	EmployeeEntity getEmployeeById(Long id);
	void updateEmployee( EmployeeEntity employee);
	
}
