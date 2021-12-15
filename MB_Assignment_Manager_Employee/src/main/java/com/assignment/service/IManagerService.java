package com.assignment.service;

import com.assignment.model.Manager;

public interface IManagerService {

	Manager managerLoginVerification(String email, String password);

	Manager managerSignUp(Manager manager);

	Boolean isManagerExist(String email);

	Manager getManagerById(Integer managerId);

}
