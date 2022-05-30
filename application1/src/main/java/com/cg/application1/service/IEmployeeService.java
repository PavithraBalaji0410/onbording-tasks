package com.cg.application1.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.cg.application1.dto.Employee;
import com.cg.application1.exception.EmployeeNotFoundException;

@Validated
public interface IEmployeeService {

	Employee add(Employee emp);

	Employee get(@NotNull long empId) throws EmployeeNotFoundException;

	List<Employee> findAll();
}
