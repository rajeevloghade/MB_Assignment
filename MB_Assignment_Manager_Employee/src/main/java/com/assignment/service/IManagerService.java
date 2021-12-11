package com.assignment.service;

import com.assignment.model.Manager;

public interface IManagerService {

	Boolean managerLoginVerification(String email, String password);

	Manager managerSignUp(Manager manager);

}
