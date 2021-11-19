package com.assignment.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.service.IManagerService;

@CrossOrigin("*")
@RestController("ManagerRestImpl")
@RequestMapping("/mgr")
public class ManagerRestImpl implements IManagerRest {

	Logger log = LoggerFactory.getLogger(ManagerRestImpl.class);

	private @Autowired IManagerService managerService;

	@GetMapping("/demo")
	public String demo() {
		log.info("demo method invoked");
		return "Hello Manager";
	}

	@GetMapping("/managerLoginVerification")
	@Override
	public @ResponseBody Boolean managerLoginVerification(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		log.trace("@managerLoginVerification in controller invoked with email: {} and password: {}", email, password);
		return managerService.managerLoginVerification(email, password);
	}
}
