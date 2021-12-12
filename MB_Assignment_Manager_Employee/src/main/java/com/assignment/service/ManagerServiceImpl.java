package com.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.IManagerDao;
import com.assignment.exception.SomethingWentWrong;
import com.assignment.model.Manager;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements IManagerService {

	Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);

	private @Autowired IManagerDao managerDao;

	@Override
	public Manager managerLoginVerification(String email, String password) {
		log.info("@managerLoginVerification in service invoked with email: {} and password: {}", email, password);
		Manager managerByEmail = managerDao.getManagerByEmail(email);
		if (managerByEmail != null) {
			if (managerByEmail.getEmail().equals(email) && managerByEmail.getPassword().equals(password)) {
				log.info("Manager Exist");
				return managerByEmail;
			} else {
				log.info("Manager Doesn't Exist");
				return null;
			}
		}
		return managerByEmail;
	}

	@Override
	public Manager managerSignUp(Manager manager) {
		log.info("@managerSignUp invoked with new managerObject : {}", manager);
		Manager newManager = null;
		try {
			if (isManagerExist(manager.getEmail())) {
				log.info("@managerSignUp got exception");
				throw new SomethingWentWrong();
			} else {
				newManager = managerDao.save(manager);
			}
		} catch (SomethingWentWrong somethingWentWrong) {
			log.info("Manager already exist with this email...!", somethingWentWrong);
		}
		return newManager;
	}

	@Override
	public Boolean isManagerExist(String email) {
		log.info("@isManagerExist in service invoked with email: {}", email);
		Manager managerByEmail = managerDao.getManagerByEmail(email);
		Boolean exist = false;
		if (managerByEmail != null) {
			if (managerByEmail.getEmail().equals(email)) {
				log.info("Manager Exist");
				exist = true;
			} else {
				log.info("Manager Doesn't Exist");
				exist = false;
			}
		}
		return exist;
	}
}
