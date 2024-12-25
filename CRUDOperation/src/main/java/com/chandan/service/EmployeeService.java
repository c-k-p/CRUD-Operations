package com.chandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.customeException.EmptyInputException;
import com.chandan.entity.Employee;
import com.chandan.repository.EmployeeRepository;

@Service
public class EmployeeService  implements EmployeeServiceInterface{
	
	@Autowired
	EmployeeRepository employeeRepository;

	

	@Override
	public Employee addEmployee(Employee emp) {
		
		if(emp.getName().isEmpty()||emp.getName().length()==0) {
			throw new EmptyInputException("601","Input Fields Are Empty");
		}
		
		return employeeRepository.save(emp);
		
	}



	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> empList=employeeRepository.findAll();
		if(empList.isEmpty()) {
			
			throw new EmptyInputException("604","Hey list completly empty, we nothing in list");
		}
		
		return empList;
	}



	@Override
	public Employee getSingleEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).get();
	}



	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);;
	}



	



	

}
