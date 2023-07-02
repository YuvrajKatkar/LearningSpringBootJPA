package com.yuvraj.SpringBootEmployee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuvraj.SpringBootEmployee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
