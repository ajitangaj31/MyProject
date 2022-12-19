package com.example.spring.jpa.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.spring.jpa.demo.dto.EmployeeDTO;

public interface IEmployeeService {
	
	public void addEmployee(EmployeeDTO employeeDTO);
	
	public List<EmployeeDTO> getEmployees(Pageable pageable);
	
	public EmployeeDTO getEmployee(Long id);

}
