package com.example.spring.jpa.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="pin_code")
	private String pinCode;
	
	private String village;
	
	@ManyToOne
	@JoinColumn(name= "employee_id")
	private Employee employee;
}
