package com.sunday.sunday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunday.sunday.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	//@Query(value="select a.street,e.salary from  employee e join address a where e.address_id = a.id",nativeQuery = true)
	//@Query(value="select first_name from employee where e_id=2",nativeQuery = true)
	@Query(value="select a.zip from  employee e join address a where e.address_id = a.id",nativeQuery = true)
	public List<String> getFirstNameByStreet();
	

}
