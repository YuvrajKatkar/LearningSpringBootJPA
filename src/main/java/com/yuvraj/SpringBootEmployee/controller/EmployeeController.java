package com.yuvraj.SpringBootEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/findAllEmployee")
	public List<Employee> getAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public Employee deleteEmployee(@PathVariable int id) {
		return employeeDao.deleteEmployee(id);
	}
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
		return employeeDao.updateEmployee( id,  employee);
	}
	@PatchMapping("/updateEmployeeSalary")
	public Employee updateEmployeeSalary(@RequestParam int id,@RequestParam int employee) {
		return employeeDao.updateEmployeeSalary( id,  employee);
	}
}
