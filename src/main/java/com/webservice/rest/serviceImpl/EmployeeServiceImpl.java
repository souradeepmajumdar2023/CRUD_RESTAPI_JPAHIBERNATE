package com.webservice.rest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.rest.exception.ResourceNotFoundException;
import com.webservice.rest.model.Employee;
import com.webservice.rest.respository.EmployeeRepository;
import com.webservice.rest.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee)
	{
		System.out.println("Saving employee: "+ employee.getFirstName() + ", "+ employee.getLastName() + ", "+ employee.getEmail()); // ✅ Debug log
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id)
	{
		Optional<Employee> employee =employeeRepository.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}

	@Override
	public Employee updateEmployee(Employee employee, long id)
	{
		Optional<Employee> employeeCheck = employeeRepository.findById(id);
		if (employeeCheck.isPresent())
		{
		    Employee existingEmployee = employeeCheck.get();

		    // Update fields
		    existingEmployee.setFirstName(employee.getFirstName());
		    existingEmployee.setLastName(employee.getLastName());
		    existingEmployee.setEmail(employee.getEmail());

		    // Save updated employee back to DB
		    return employeeRepository.save(existingEmployee);
		    }
		else
		{
		    // If not found, throw your custom exception
		    throw new ResourceNotFoundException("Employee","id", id);
		}
	}

	@Override
	@Transactional
	public void deleteEmployee(long id)
	{
	    Optional<Employee> employeeCheck = employeeRepository.findById(id);
	    if (employeeCheck.isPresent())
	    {
	        employeeRepository.deleteById(id);
	    } 
	    else
	    {
	        throw new ResourceNotFoundException("Employee", "id", id);
	    }
	}
}