package com.assignment.service;

import java.util.List;

import com.assignment.model.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployee();

	Employee getEmployeeById(Integer employeeId);

	void deleteEmployee(Integer employeeId);

	Employee updateEmployee(Employee employee);

	Employee addEmployee(Employee employee);

	Boolean isEmployeeExistOrNotByEmail(String email);

	List<Employee> searchEmployee(String name);

}
