package com.example.spring.jpa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring.jpa.demo.dto.PersonVillage;
import com.example.spring.jpa.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query()
	List<PersonVillage> findAllEmployees();
	
	//using query
	int updateSalaryOfEmployee();
	
	//update using dynamic update and insert
	
	//Get all employee sorted by name
	
	//Sort all employees by length of name.. name with more chars should come last

}
