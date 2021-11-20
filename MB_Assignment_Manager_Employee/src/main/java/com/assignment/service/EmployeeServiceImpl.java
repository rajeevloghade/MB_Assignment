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
	public Employee getEmployeeById(Integer employeeId) {
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
		return updatedEmployee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		log.info("@addEmployee invoked with new employeeObject : {}", employee);
		Employee newEmployee = null;
		try {
			if (isEmployeeExistOrNotByEmail(employee.getEmail())) {
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
	public Boolean isEmployeeExistOrNotByEmail(String email) {
		log.info("@isEmployeeExistOrNot in service invoked with email : {}", email);
		Employee employeeByEmail = employeeDao.findByEmail(email);
		Boolean exist = false;
		if (employeeByEmail != null) {
			log.info("Employee Exist with email : {}", email);
			exist = true;
		} else {
			log.info("Employee Doesn't Exist with email : {}", email);
			exist = false;
		}
		return exist;
	}

	@Override
	public List<Employee> searchEmployee(String name) {
		log.info("@searchEmployee in service invoked with name : {}", name);
		List<Employee> employeeByName = employeeDao.findByFirstName(name);
		if (!employeeByName.isEmpty()) {
			log.info("findByFirstName : {}", employeeByName.size());
			return employeeByName;
		} else {
			employeeByName = employeeDao.findByLastName(name);
			log.info("findByLastName : {}", employeeByName.size());
			return employeeByName;
		}
	}

}
