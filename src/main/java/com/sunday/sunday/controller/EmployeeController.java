package com.sunday.sunday.controller;



import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunday.sunday.Service.EmployeeService;
import com.sunday.sunday.entities.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee(){
	return empService.getAllEmployee();
	}	
	
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
	return empService.saveEmployee(emp);
	}
	
	
	@GetMapping("/getEmployeeCount")
	public ResponseEntity<HashMap<String, Integer>> getEmployeeCount(){
	return empService.getEmployeeCount();
	}
	
	@GetMapping(value="get-by-id")
	public Optional<Employee> getByID(@RequestParam Long id){
	return empService.getByID(id);
	}
	
	@GetMapping(value ="getSalaryZip")
	public HashMap<Long, String> getTotalSalaryByZipCode() {
	return empService.getTotalSalaryByZipCode();
	}
	
	@GetMapping(value = "get-salary-by-zip")
	public ResponseEntity<Map<String, BigInteger>> getTotalSalaryByZip() {		
		return empService.getTotalSalaryByZip();
	}
	
	@GetMapping(value="get-name-by-address")
	public List<String> getFirstNameByStreet() {
		return empService.getFirstNameByStreet();
	}

	@GetMapping(value="get-state-tax-by-id")
	public BigInteger getStateTaxByID(@RequestParam Long id ) {
		return empService.getStateTaxByID(id);
	}
	
	
}
