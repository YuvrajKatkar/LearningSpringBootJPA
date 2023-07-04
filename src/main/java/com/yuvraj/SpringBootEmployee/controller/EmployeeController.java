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
import com.yuvraj.SpringBootEmployee.service.EmployeeService;
import com.yuvraj.SpringBootEmployee.util.ResponseStructure;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveSetEmployeeGrade(employee);
	}
	@GetMapping("/findEmployee")
	public ResponseStructure<Employee> getEmployee(@RequestParam int id) {
		return employeeService.getEmployee(id);
	}
	@GetMapping("/findAllEmployee")
	public ResponseStructure<List<Employee>> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/findAllSalary")
	public ResponseStructure<List<Employee>> getAllEmployeesBySalaryGreaterThan(@RequestParam double sal){
		return employeeService.getAllEmployeesBySalaryGreaterThan( sal );
	}
	@GetMapping("/getEmployeeByEmail")
	public ResponseStructure<Employee> getEmployeeByEmail(@RequestParam String email) {
		return employeeService.getEmployeeByEmail(email);
	}
	@GetMapping("/getEmployeeByPhone/{phone}")
	public ResponseStructure<Employee> getEmployeeByPhone(@PathVariable long phone) {
		return employeeService.getEmployeeByPhone(phone);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseStructure<Employee>  deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
	@PutMapping("/updateEmployee")
	public ResponseStructure<Employee> updateEmployee(@RequestParam int id,@RequestBody Employee employee) {
		return employeeService.updateSetGradeEmployee(id,employee);
	}
	@PatchMapping("/updateEmployeeSalary")
	public Employee updateEmployeeSalary(@RequestParam int id,@RequestParam int employee) {
		return employeeDao.updateEmployeeSalary( id,  employee);
	}
}
