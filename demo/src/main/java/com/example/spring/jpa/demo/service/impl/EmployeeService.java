package com.example.spring.jpa.demo.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.spring.jpa.demo.dto.EmployeeDTO;
import com.example.spring.jpa.demo.exception.NoDataExistException;
import com.example.spring.jpa.demo.mapper.EmployeeMapper;
import com.example.spring.jpa.demo.repository.EmployeeRepository;
import com.example.spring.jpa.demo.service.IEmployeeService;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Transactional
public class EmployeeService implements IEmployeeService {
	
	private final EmployeeMapper employeeMapper;
	
	private final EmployeeRepository employeeRepository;

	@Override
	public void addEmployee(EmployeeDTO employeeDTO) {
		var employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
		employee.getAddresses().forEach(address -> address.setEmployee(employee));
		employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeDTO> getEmployees(Pageable pageable) {
		var employees = employeeRepository.findAll(pageable);
		if(employees.isEmpty()) {
			throw new NoDataExistException("Employee data doesn't exist");
		}
		return employeeMapper.employeesToEmployeeDTOs(employees.getContent());
	}
	
	@Override
	public EmployeeDTO getEmployee(Long id) {
		var employee = employeeRepository.findById(id);
		if(employee.isEmpty()) {
			throw new NoDataExistException("No Data for employee id " + id + " exist");
		}
		return employeeMapper.employeeToEmployeeDTO(employee.get());
	}

}
