package com.sunday.sunday.entities;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //for getter and setter
@NoArgsConstructor //for default constructor
@AllArgsConstructor //for all argument constructor
@Entity
@Table(name="ems_employee")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	private BigInteger salary;  //int is primitive
	
	//OnetoOne, OneToMany, ManyToTone ManyToMany
	
	//unidirectional
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="address_id", referencedColumnName="id")
	private Address address;  //address_id
	
	//bidirectional if you write mapping on department also
	@ManyToOne
	@JoinColumn(name="department_id")
	@JsonIgnoreProperties("employeeList")
	private Department department;
	
	@Transient //ignore this age property during persistance 
	private int age;
	
	
	
	
}
