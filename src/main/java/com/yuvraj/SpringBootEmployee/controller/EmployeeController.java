package com.yuvraj.SpringBootEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuvraj.SpringBootEmployee.dao.EmployeeDao;
import com.yuvraj.SpringBootEmployee.dto.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	@GetMapping("/findEmployee")
	public Employee getEmployee(@RequestParam int id) {
		return employeeDao.getEmployee(id);
	}
}
