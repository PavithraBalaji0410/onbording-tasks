package com.cg.application1.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddEmployeeRequest {

	@NotBlank
	private String name;
	@NotNull
	@Min(21)
	@Max(55)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AddEmployeeRequest( @NotBlank String name, @NotNull @Min(21) @Max(55) int age) {
		super();
		
		this.name = name;
		this.age = age;
	}

	public AddEmployeeRequest() {
		super();
	}
	

}
