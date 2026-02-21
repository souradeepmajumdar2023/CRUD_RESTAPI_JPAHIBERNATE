package com.webservice.rest.service;

import java.util.List;

import com.webservice.rest.model.Employee;

public interface EmployeeService
{
	//To create new records- CREATE OPERATION
	Employee saveEmployee(Employee employee);
	
	//To fetch all records- READ OPERATION
	List<Employee> getAllEmployees();
	
	//To fetch any record by Id- READ OPERATION
	Employee getEmployeeById(long id);
	
	//To update any record- UPDATE OPERATION
	Employee updateEmployee(Employee employee, long id);
	
	//To delete any record- DELETE OPERATION
	void deleteEmployee(long id);
}
