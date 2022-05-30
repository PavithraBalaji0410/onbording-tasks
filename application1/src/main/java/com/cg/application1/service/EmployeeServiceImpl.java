package com.cg.application1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.application1.dao.IEmployeeDao;
import com.cg.application1.dto.Employee;
import com.cg.application1.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	private static final Logger Log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private IEmployeeDao dao;

	@Override
	public Employee add(Employee emp) {

		Employee em = dao.save(emp);
		Log.debug("Employee added");
		return em;

	}

	@Override
	public Employee get(long empId) throws EmployeeNotFoundException {
		Employee found = dao.findById(empId);
		if (found==null) {
			throw new EmployeeNotFoundException("No such employee");
		}
		Log.debug("Employee found");
		return found;

	}

	@Override
	public List<Employee> findAll() {
		return dao.findAll();

	}

}