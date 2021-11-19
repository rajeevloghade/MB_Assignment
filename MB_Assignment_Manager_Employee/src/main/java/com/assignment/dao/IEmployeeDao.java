package com.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Employee;

@Repository("IEmployeeDao")
public interface IEmployeeDao extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);

	Employee findByEmployeeId(Integer employeeId);

}
