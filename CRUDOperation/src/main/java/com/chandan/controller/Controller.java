package com.chandan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.entity.Employee;
import com.chandan.service.EmployeeServiceInterface;

@RestController
@ControllerAdvice
@RequestMapping("/code")
public class Controller {

	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	/*
	 * 
	 * C- create R- retrieve U- update D- delete
	 * 
	 */

	// CREATE
 
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee employee = employeeServiceInterface.addEmployee(emp);

		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	// RETRIEVE(1st way)
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> getEmployee = employeeServiceInterface.getAllEmployee();

		return new ResponseEntity<List<Employee>>(getEmployee, HttpStatus.OK);

	}

	// RETRIEVE(2nd way)
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getSingleEmployee(@PathVariable int id) {
		Employee SingleEmployee = employeeServiceInterface.getSingleEmployee(id);

		return new ResponseEntity<Employee>(SingleEmployee, HttpStatus.OK);
	}

	// UPDATE By Id

	@PostMapping("/emp/update/{id}")
	public ResponseEntity<Employee> updateSingleEmployee(@PathVariable int id, @RequestBody Employee emp) {
		Employee updatedEmployee = employeeServiceInterface.getSingleEmployee(id);

		updatedEmployee.setName(emp.getName());

		Employee addEmployee = employeeServiceInterface.addEmployee(updatedEmployee);
		return new ResponseEntity<Employee>(addEmployee, HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		employeeServiceInterface.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	//Update
	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp) {
		Employee updatedEmp=employeeServiceInterface.addEmployee(emp);
		
		return new ResponseEntity<Employee>(updatedEmp,HttpStatus.ACCEPTED);
	}
	

}
