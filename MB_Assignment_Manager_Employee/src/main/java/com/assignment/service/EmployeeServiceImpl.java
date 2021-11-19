package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.IEmployeeDao;
import com.assignment.exception.SomethingWentWrong;
import com.assignment.model.Employee;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements IEmployeeService {

	Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private @Autowired IEmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		log.info("@getAllEmployee invoked");
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeByEmployeeId(Integer employeeId) {
		log.info("@getEmployeeById invoked with employeeId : {}", employeeId);
		Optional<Employee> employeeById = employeeDao.findById(employeeId);
		Employee employeeModel = null;
		if (employeeById.isPresent())
			employeeModel = employeeById.get();
		return employeeModel;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		log.info("@deleteEmployee invoked with employeeId : {}", employeeId);
		employeeDao.deleteById(employeeId);
		log.info("EMPLOYEE DELETED With employeeId: {}", employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		log.info("@updateEmployee invoked with employeeId : {}", employee.getEmployeeId());

		Employee updatedEmployee = null;
		if (isEmployeeExistOrNot(employee.getEmail())) {
			log.info("@updateEmployee got exception : ");
			throw new SomethingWentWrong("Employee already exist with this email...!");
		} else {
			Optional<Employee> employeeById = employeeDao.findById(employee.getEmployeeId());
			if (employeeById.isPresent()) {
				updatedEmployee = employeeById.get();
				log.info("Updating employee values");
				updatedEmployee.setFirstName(employee.getFirstName());
				updatedEmployee.setLastName(employee.getLastName());
				updatedEmployee.setDob(employee.getDob());
				updatedEmployee.setCompany(employee.getCompany());
				updatedEmployee.setMobile(employee.getMobile());
				updatedEmployee.setAddress(employee.getAddress());
				employeeDao.save(updatedEmployee);
				log.info("EMPLOYEE UPDATED : {}", updatedEmployee);
			}
		}
		return updatedEmployee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		log.info("@addEmployee invoked with new employeeObject : {}", employee);
		Employee newEmployee = null;
		try {
			if (isEmployeeExistOrNot(employee.getEmail())) {
				log.info("@addEmployee got exception");
				throw new SomethingWentWrong();
			} else {
				newEmployee = employeeDao.save(employee);
			}
		} catch (SomethingWentWrong somethingWentWrong) {
			log.info("Employee already exist with this email...!", somethingWentWrong);
		}
		return newEmployee;
	}

	@Override
	public Boolean isEmployeeExistOrNot(String email) {
		log.info("@isEmployeeExistOrNot in service invoked with email : {}", email);
		Employee employeeByEmail = employeeDao.getEmployeeByEmail(email);
		Boolean exist = false;
		if (employeeByEmail != null) {
			if (employeeByEmail.getEmail().equals(email)) {
				log.info("Employee Exist");
				exist = true;
			} else {
				log.info("Employee Doesn't Exist");
				exist = false;
			}
		}
		return exist;
	}

}
