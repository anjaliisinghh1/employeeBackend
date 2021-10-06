package com.nagarro.employeeDetailsBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employeeDetailsBackend.entity.EmployeeEntity;
import com.nagarro.employeeDetailsBackend.service.EmployeeService;

@RestController
@RequestMapping("/employeedetails")
public class EmployeeController {
	
	 @Autowired
	 private EmployeeService employeeService;
	 
	 public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }
		
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employeeList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
	
	@GetMapping("/employee/{Id}")
	    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable long Id) {
	        return new ResponseEntity<>(employeeService.getEmployeeById(Id), HttpStatus.OK);
	    }
	
	@PostMapping("/employee")
	 public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity employees = employeeService.saveEmployee(employee);
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("employee","/employeedetails/" + employees.getEmployeeCode().toString());
	        return new ResponseEntity<>(employees, httpHeaders, HttpStatus.CREATED);
	    }

	@PutMapping("/employee/{Id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable("Id") Long Id, @RequestBody EmployeeEntity employee) {
		employee.setEmployeeCode(Id);
		employeeService.updateEmployee( employee);
        return new ResponseEntity<>(employeeService.getEmployeeById(Id), HttpStatus.OK);
        
    }

}

