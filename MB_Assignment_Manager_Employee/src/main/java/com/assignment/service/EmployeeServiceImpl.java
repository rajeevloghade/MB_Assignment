package com.assignment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.IEmployeeDao;
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

		Optional<Employee> employeeById = employeeDao.findById(employee.getEmployeeId());
		Employee updatedEmployee = null;
		if (employeeById.isPresent()) {
			updatedEmployee = employeeById.get();
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
		return employeeDao.save(employee);
	}

}
