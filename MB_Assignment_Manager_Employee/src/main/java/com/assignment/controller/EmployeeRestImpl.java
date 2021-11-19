package com.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Employee;
import com.assignment.service.IEmployeeService;

@CrossOrigin("*")
@RestController("EmployeeRestImpl")
@RequestMapping("/emp")
public class EmployeeRestImpl implements IEmployeeRest {

	Logger log = LoggerFactory.getLogger(EmployeeRestImpl.class);

	private @Autowired IEmployeeService employeeService;

	@GetMapping("/demo")
	public String demo() {
		log.info("demo method invoked");
		return "Hello Employee";
	}

	@GetMapping("/getEmployeeById/{employeeId}")
	@Override
	public Employee getEmployeeByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
		log.trace("@getEmployeeById invoked with employeeId : {}", employeeId);
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}

	@GetMapping("/getAllEmployee")
	@Override
	public List<Employee> getAllEmployee() {
		log.trace("@getAllEmployee invoked");
		return employeeService.getAllEmployee();
	}

	@PostMapping("/addEmployee")
	@Override
	public Employee addEmployee(@RequestBody Employee employee) {
		log.trace("@addEmployee invoked with new employeeObject : {}", employee);
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/updateEmployee")
	@Override
	public Employee updateEmployee(@RequestBody Employee employee) {
		log.trace("@updateEmployee invoked with employeeId : {}", employee.getEmployeeId());
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{employeeId}")
	@Override
	public void deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		log.trace("@deleteEmployee invoked with employeeId : {}", employeeId);
		employeeService.deleteEmployee(employeeId);
	}

	@GetMapping("/isEmployeeExistOrNot")
	@Override
	public Boolean isEmployeeExistOrNot(@RequestParam("email") String email) {
		log.trace("@isEmployeeExistOrNot invoked with email : {}", email);
		return employeeService.isEmployeeExistOrNot(email);
	}

}
