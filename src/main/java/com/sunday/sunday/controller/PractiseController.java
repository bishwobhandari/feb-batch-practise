package com.sunday.sunday.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunday.sunday.entities.Employee;
import com.sunday.sunday.repository.EmployeeRepository;

@RestController
@RequestMapping("/practise")
public class PractiseController {
	
//	
//	@Autowired
//	EmployeeRepository empRepo;
//	
//	@GetMapping("/getEmployeeCount")
//		public ResponseEntity<HashMap<String, Integer>> getAllEmployee(){
//		List<Employee> emplist =  empRepo.findAll();
//		
//		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
//		
//		//forloop
//		emplist.stream().forEach(x->{
//			
//			if(map1.containsKey(x.getFirstName())) {
//				map1.put(x.getFirstName(), map1.get(x.getFirstName()+1));
//			}
//			else {
//				map1.put(x.getFirstName(), 1);
//			}
//		});
//		
//		System.out.println(map1);
//		return new ResponseEntity<>(map1, HttpStatus.OK);
//		}
	
}
