package com.cg.application1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.application1.dto.Employee;
import com.cg.application1.exception.EmployeeNotFoundException;
import com.cg.application1.mapper.EmployeeMapper;
import com.cg.application1.service.EmployeeServiceImpl;
import com.cg.application1.vo.AddEmployeeRequest;
import com.cg.application1.vo.EmployeeDetails;

@Validated
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;
	
	/*
	 * @Autowired public EmployeeMapper mapper;
	 */

	@PostMapping("/employee/create")
	public EmployeeDetails create(@RequestBody @Valid AddEmployeeRequest request) {
		Employee add=EmployeeMapper.INSTANCE.convertToDto(request);
		Employee result = service.add(add);
		return EmployeeMapper.INSTANCE.convert(result);
	}

	
	  @GetMapping("/employee/find/{id}") public EmployeeDetails
	  get(@PathVariable("id") long id) throws EmployeeNotFoundException {
	  EmployeeDetails result = EmployeeMapper.INSTANCE.convert(service.get(id));
	  return result; }
	  
	
	  @GetMapping("/employee/list") public List<EmployeeDetails> getAll() {
	  List<EmployeeDetails> result = EmployeeMapper.INSTANCE.convertList(service.findAll()); return
	  result; }
	 
	 

}
