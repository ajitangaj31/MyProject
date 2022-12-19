package com.example.spring.jpa.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class EmployeeDTO {
	
	@NotNull(message = "employee name can not be null")
	@NotBlank(message = "employee name can not be blank")
	private String name;
	
	@Min(value = 10000, message = "employee salary can not be less than 10k")
	@Max(value = 20000, message = "employee salary can not be more than 20k")
	private Long salary;
	
	@NotEmpty(message = "addresses can not be empty")
	private List<AddressDTO> addresses;
}
