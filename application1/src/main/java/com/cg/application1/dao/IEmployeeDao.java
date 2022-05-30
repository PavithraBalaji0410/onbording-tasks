package com.cg.application1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.application1.dto.Employee;

@Repository
public interface IEmployeeDao {
	
	Employee save(Employee emp);
	Employee findById(long id);
	List<Employee> findAll();

}

