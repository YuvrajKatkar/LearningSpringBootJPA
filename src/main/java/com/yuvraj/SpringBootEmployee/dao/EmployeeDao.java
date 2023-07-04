package com.yuvraj.SpringBootEmployee.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yuvraj.SpringBootEmployee.dto.Employee;
import com.yuvraj.SpringBootEmployee.repo.EmployeeRepo;
import com.yuvraj.SpringBootEmployee.util.ResponseStructure;
@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional= repo.findById(id);
		if(optional.isEmpty())return null;
		return optional.get();
	}
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> list =repo.findAll();
		return list;
	}
	public Employee deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> optional =repo.findById(id);
		if(optional.isEmpty())return null;
		repo.delete(optional.get());
		return optional.get();
	}
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optional=repo.findById(id);
		
		if(optional.isEmpty())return null;
		Employee dBEmployee =optional.get();
		employee.setId(dBEmployee.getId());
		repo.save(employee);
		return employee;
		
	}
	public Employee updateEmployeeSalary(int id, double employee) {
		// TODO Auto-generated method stub
Optional<Employee> optional=repo.findById(id);
		
		if(optional.isEmpty())return null;
		Employee dBEmployee =optional.get();
		dBEmployee.setSalary(employee);
		repo.save(dBEmployee);
		return dBEmployee;
	}
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		Employee employee = repo.getByEmail(email);
		//System.out.println(employee);
		return employee;
	}
	public Employee getEmployeeByPhone(long phone) {
		// TODO Auto-generated method stub
		Employee employee = repo.employeeByPhone(phone);
		//System.out.println(employee);
		return employee;
	}
	public List<Employee> getAllEmployeesBySalaryGreaterThan(double sal) {
		// TODO Auto-generated method stub
		
		return repo.getBySalaryGreaterThan(sal);
	}
}
