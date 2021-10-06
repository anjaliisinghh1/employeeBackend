package com.nagarro.employeeDetailsBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.employeeDetailsBackend.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
