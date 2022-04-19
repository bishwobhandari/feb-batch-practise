package com.sunday.sunday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunday.sunday.entities.Department;
import com.sunday.sunday.repository.DepartmentRepository;

@RestController
@RequestMapping("department")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
		public List<Department> getAllDepartment(){
			return departmentRepository.findAll();
		}
	
	
}
