package com.cg.application1.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddEmployeeRequest {
	
	private int id;
	@NotBlank
	private String name;
	@NotNull
	@Min(21)
	@Max(55)
	private int age;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public AddEmployeeRequest(int id, @NotBlank String name, @NotNull @Min(21) @Max(55) int age) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
	}

	public AddEmployeeRequest() {
		super();
	}
	

}
