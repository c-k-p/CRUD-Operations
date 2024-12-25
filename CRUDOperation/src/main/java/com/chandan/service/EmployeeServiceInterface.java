package com.chandan.service;

import java.util.List;

import com.chandan.entity.Employee;

public interface EmployeeServiceInterface {

	
	
	public Employee addEmployee(Employee emp);

	public List<Employee> getAllEmployee();

	public Employee getSingleEmployee(int id);

	public void deleteById(int id);


	
	
}
