package com.cg.application1.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cg.application1.dto.Employee;
import com.cg.application1.vo.AddEmployeeRequest;
import com.cg.application1.vo.EmployeeDetails;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	

	@Mapping(source="name",target ="name")
	Employee convertToDto(AddEmployeeRequest request);
	
	@Mapping(source="id",target ="id")
	EmployeeDetails convert(Employee emp);
	
	@Mapping(source="id",target ="id")
	List<EmployeeDetails> convertList(Collection<Employee> list);
}

