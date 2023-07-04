package com.yuvraj.SpringBootEmployee.service;

import java.util.List;

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
	ResponseStructure<List<Employee>> responseStructureList = new ResponseStructure<>();
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
		responseStructure.setMessage("updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.updateEmployee(id, employee));
		return responseStructure;
	}
	public ResponseStructure<Employee> getEmployee(int id) {
		// TODO Auto-generated method stub
		responseStructure.setMessage("employee fetched Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.getEmployee(id ));
		return responseStructure;
	}
	public ResponseStructure<List<Employee>> getAllEmployees() {
		// TODO Auto-generated method stub
		responseStructureList.setMessage("All employees fetched Successfully");
		responseStructureList.setStatus(HttpStatus.OK.value());
		responseStructureList.setData(employeeDao.getAllEmployees());
		return responseStructureList;
	}
	public ResponseStructure<List<Employee>> getAllEmployeesBySalaryGreaterThan(double sal) {
		// TODO Auto-generated method stub
		responseStructureList.setMessage("All employees fetched Successfully with sal > "+sal);
		responseStructureList.setStatus(HttpStatus.OK.value());
		responseStructureList.setData(employeeDao.getAllEmployeesBySalaryGreaterThan(sal));
		return responseStructureList;
	}
	public ResponseStructure<Employee> getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		responseStructure.setMessage("employee fetched Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.getEmployeeByEmail(email ));
		return responseStructure;
	}
	public ResponseStructure<Employee> getEmployeeByPhone(long phone) {
		// TODO Auto-generated method stub
		responseStructure.setMessage("employee fetched Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.getEmployeeByPhone(phone ));
		return responseStructure;
	}
	public ResponseStructure<Employee> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		responseStructure.setMessage("employee deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(employeeDao.deleteEmployee(id ));
		return responseStructure;
	}

}
