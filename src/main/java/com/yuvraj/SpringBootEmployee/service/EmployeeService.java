package com.yuvraj.SpringBootEmployee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.yuvraj.SpringBootEmployee.dao.EmployeeDao;
import com.yuvraj.SpringBootEmployee.dto.Employee;
import com.yuvraj.SpringBootEmployee.util.ResponseStructure;
@Component
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
	public ResponseStructure<Employee> saveSetEmployeeGrade(Employee employee) {
		double sal = employee.getSalary();
		if(sal>40000) {
			employee.setGrade('A');
		}
		else if(sal>25000) {
			employee.setGrade('B');
		}
		else if(sal>10000) {
			employee.setGrade('C');
		}
		else {
			employee.setGrade('D');
		}
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.saveEmployee(employee));
		
		return responseStructure;
	}
	public ResponseStructure<Employee> updateSetGradeEmployee(int id,Employee employee) {
		double sal = employee.getSalary();
		if(sal>40000) {
			employee.setGrade('A');
		}
		else if(sal>25000) {
			employee.setGrade('B');
		}
		else if(sal>10000) {
			employee.setGrade('C');
		}
		else {
			employee.setGrade('D');
		}
		responseStructure.setMessage("Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(employeeDao.updateEmployee(id, employee));
		return responseStructure;
	}

}
