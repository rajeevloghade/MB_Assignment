package com.assignment.controller;

import com.assignment.model.Manager;

public interface IManagerRest {

	Boolean managerLoginVerification(String email, String password);

	Manager managerSignUp(Manager manager);
}
