package com.webservice.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.rest.model.Employee;
import com.webservice.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	
	//To create new records- CREATE OPERATION
	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		System.out.println("Saving employee: "+ employee.getFirstName() + ", "+ employee.getLastName() + ", "+ employee.getEmail()); // ✅ Debug log
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//To fetch all records- READ OPERATION
	@GetMapping("/getEmployees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//To fetch any record by Id- READ OPERATION
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	//To update any record by Id- UPDATE OPERATION
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") long employeeId, @RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long employeeId)
	{
		return new ResponseEntity<String>("Employee deleted succesfully", HttpStatus.OK);
	}
}