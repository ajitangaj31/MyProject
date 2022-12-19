package com.example.spring.jpa.demo.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.spring.jpa.demo.dto.EmployeeDTO;
import com.example.spring.jpa.demo.entity.Employee;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {
	
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);
	
	EmployeeDTO employeeToEmployeeDTO(Employee employee);
	
	List<EmployeeDTO> employeesToEmployeeDTOs(List<Employee> employees);
}
