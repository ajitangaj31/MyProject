package com.example.spring.jpa.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class AddressDTO {
	
	@Pattern(regexp="^[0-9]{6}",message="length must be 6")  
	private String pinCode;
	
	@NotNull(message = "village name can not be null")
	private String village;

}
