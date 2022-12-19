package com.example.spring.jpa.demo.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.jpa.demo.dto.EmployeeDTO;
import com.example.spring.jpa.demo.service.IEmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
public class EmployeeController {
	
	private final IEmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
		employeeService.addEmployee(employeeDTO);
		return new ResponseEntity<>("Employee Added successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/all")
	public ResponseEntity<List<EmployeeDTO>> getEmployees(Pageable pageable){
		return new ResponseEntity<>(employeeService.getEmployees(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> getEmployees(@PathVariable("id") @Max(value = 500, message="id can't be more than 500") Long id){
		return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
	}
}
