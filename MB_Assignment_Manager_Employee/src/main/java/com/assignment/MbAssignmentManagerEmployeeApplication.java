package com.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assignment.service.EmployeeServiceImpl;

@SpringBootApplication
public class MbAssignmentManagerEmployeeApplication {

	static Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public static void main(String[] args) {
		SpringApplication.run(MbAssignmentManagerEmployeeApplication.class, args);
		log.info("Springboot Application Started Successfully...");
	}

}
