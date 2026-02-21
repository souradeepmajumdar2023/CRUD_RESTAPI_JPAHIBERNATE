package com.webservice.rest.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

}
