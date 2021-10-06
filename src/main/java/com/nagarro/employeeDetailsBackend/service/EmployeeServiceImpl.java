package com.nagarro.employeeDetailsBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeeDetailsBackend.entity.EmployeeEntity;
import com.nagarro.employeeDetailsBackend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = new ArrayList<>();
		employeeRepository.findAll().forEach(employeeList::add);
		return employeeList;
	}

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public EmployeeEntity getEmployeeById(Long id) {
		Optional<EmployeeEntity> optional = employeeRepository.findById(id);
		EmployeeEntity employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void updateEmployee(EmployeeEntity employee) {
		Optional<EmployeeEntity> presentemployee = this.employeeRepository.findById(employee.getEmployeeCode());

		if (presentemployee.isPresent()) {
			EmployeeEntity employeeUpdate = presentemployee.get();
			employeeUpdate.setEmployeeName(employee.getEmployeeName());
			employeeUpdate.setLocation(employee.getLocation());
			employeeUpdate.setEmail(employee.getEmail());
			employeeUpdate.setDateOfBirth(employee.getDateOfBirth());
			employeeRepository.save(employeeUpdate);
		} else {
			throw new RuntimeException(" Employee not found for id:" + employee.getEmployeeCode());
		}
	}
	

}
