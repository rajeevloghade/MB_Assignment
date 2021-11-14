package com.assignment.service;

import java.util.List;

import com.assignment.model.Employee;

public interface IEmployeeService {

	List<Employee> getAllEmployee();

	Employee addEmployee(Employee employeeModel);

	Employee updateEmployee(Employee employeeModel);

	void deleteEmployee(Integer id);

	Employee getEmployeeByEmployeeId(Integer employeeId);

}
