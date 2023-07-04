package com.yuvraj.SpringBootEmployee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yuvraj.SpringBootEmployee.dto.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	public Employee getByEmail(String email);

	@Query("select e from Employee e where e.phone=?1")
	public Employee employeeByPhone(long phone);
	//sdf

	public List<Employee> getBySalaryGreaterThan(double sal);
}
