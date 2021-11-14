package com.assignment.controller;

import java.util.List;

import com.assignment.model.Employee;

public interface IEmployeeRest {

	List<Employee> getAllEmployee();

	Employee addEmployee(Employee employeeModel);

	Employee updateEmployee(Employee employeeModel);

	void deleteEmployee(Integer id);

	Employee getEmployeeByEmployeeId(Integer employeeId);

	Boolean isEmployeeExistOrNot(String email);

}
