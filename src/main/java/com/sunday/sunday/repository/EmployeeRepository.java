package com.sunday.sunday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunday.sunday.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	

}
