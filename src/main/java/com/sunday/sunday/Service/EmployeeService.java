package com.sunday.sunday.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sunday.sunday.constants.AppConstant;
import com.sunday.sunday.entities.Address;
import com.sunday.sunday.entities.Employee;
import com.sunday.sunday.entities.FederalTax;
import com.sunday.sunday.repository.AddressRepository;
import com.sunday.sunday.repository.EmployeeRepository;
import com.sunday.sunday.repository.FederalIncomeTaxRepository;
import com.sunday.sunday.repository.TaxRateRepository;

@Service
public class EmployeeService implements AppConstant {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	AddressRepository addRepo;

	@Autowired
	TaxRateRepository taxRepo;
	
	@Autowired
	FederalIncomeTaxRepository federalRepo;

	public List<Employee> getAllEmployee() {
		return empRepo.findAll();
	}

	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public ResponseEntity<HashMap<String, Integer>> getEmployeeCount() {
		List<Employee> emplist = empRepo.findAll();
		System.out.println("get all employee");
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();

		emplist.stream().forEach(x -> {

			if (map1.containsKey(x.getFirstName())) {
				map1.put(x.getFirstName(), map1.get(x.getFirstName()) + 1);
			} else {
				map1.put(x.getFirstName(), 1);
			}
		});

		return new ResponseEntity<>(map1, HttpStatus.OK);
	}

	public Optional<Employee> getByID(Long id) {
		return empRepo.findById(id);
	}

//write a api to get id and zip 
	public HashMap<Long, String> getIdZip() {

		List<Address> addressList = addRepo.findAll();
		HashMap<Long, String> idZip = new HashMap<Long, String>();

		addressList.stream().forEach(x -> {
			idZip.put(x.getId(), x.getZip());

		});
		return idZip;
	}

	//get total salary with zip 
	public ResponseEntity<Map<String, BigInteger>> getTotalSalaryByZip() {
		List<Employee> empList = empRepo.findAll();
		Map<String, BigInteger> mapList = new HashMap<String, BigInteger>();
		// BigInteger total= BigInteger.valueOf(0);
		
		empList.stream().forEach(x -> {
			if (mapList.containsKey(x.getAddress().getZip())) {

				mapList.put(x.getAddress().getZip(), mapList.get(x.getAddress().getZip()).add(x.getSalary()));

			} else {
				mapList.put(x.getAddress().getZip(), x.getSalary());
			}
		});
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

//salary after deducting state tax and federal tax
	public BigInteger getStateTaxByID(Long id) {

		Employee emp = empRepo.findById(id).orElseThrow(() -> new RuntimeException("employee not found"));

		BigInteger taxRate = null;
		BigInteger deductedSalarySTax = null;
		BigInteger fDeductedSalary = null;
		

		if (emp != null) {
			taxRate = taxRepo.getStateTax(emp.getAddress().getState());
		}

		if (taxRate != null) {
			List<FederalTax> fedTax = federalRepo.findAll();
			System.out.println(fedTax.get(0).getMax());
			System.out.println(fedTax.get(0).getMin());
			BigInteger rate1 = null;
			
			for(int x = 0;x<fedTax.size();x++){
				if(emp.getSalary().compareTo(fedTax.get(x).getMin())>0 &&emp.getSalary().compareTo(fedTax.get(x).getMax())<0) {
					rate1 =fedTax.get(x).getRate();
				}
					
			}
			System.out.println("rate " +rate1);
			fDeductedSalary = emp.getSalary().subtract(emp.getSalary().multiply(rate1).divide(ONE_HUNDRED));
			deductedSalarySTax = fDeductedSalary.subtract(fDeductedSalary.multiply(taxRate).divide(ONE_HUNDRED));
			System.out.println("Salary after deduction of Federal Tax : " + fDeductedSalary);
			System.out.println("Salary after deduction of Sales Tax : " + deductedSalarySTax);
			
			
		}
		

		return deductedSalarySTax;
	}
//Employee name with age greater then 30 
	public Map<String, Integer> getFirstNameOlderThan30() {

		List<Employee> employee = empRepo.findAll();
		Map<String, Integer> map = new HashMap<String, Integer>();

		employee.stream().forEach(x -> {
			LocalDate birthDate = x.getBirthDate();
			LocalDate todayDate = LocalDate.now();
			Period p = Period.between(birthDate, todayDate);
			x.setAge(p.getYears());
		});

		employee.stream().forEach(x -> {
			if (x.getAge() >= 30) {
				map.put(x.getFirstName(), x.getAge());
			}
		});

		return map;
	}

}
