package com.yuvraj.SpringBootEmployee.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yuvraj.SpringBootEmployee.dto.Employee;
import com.yuvraj.SpringBootEmployee.repo.EmployeeRepo;
@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;
	public Employee saveEmployee(Employee employee) {
		return repo.save(employee);
	}
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
}
