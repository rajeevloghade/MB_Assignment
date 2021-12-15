package com.assignment.controller;

import com.assignment.model.Manager;
import com.assignment.model.Response;

public interface IManagerRest {

	Response managerLoginVerification(String email, String password);

	Manager managerSignUp(Manager manager);

	Manager getManagerById(Integer managerId);

}
