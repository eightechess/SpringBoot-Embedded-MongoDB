package com.verizon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.model.Employee;
import com.verizon.repo.EmployeeRepo;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo  employeeRepo;
	
	@GetMapping ("/getAllEmployees")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();		
	}
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeRepo.save(employee);
		return "Employee "+employee.getEmpid() +" saved";
		
	}

}
