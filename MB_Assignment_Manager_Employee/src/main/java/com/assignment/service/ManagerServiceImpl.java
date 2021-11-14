package com.assignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dao.IManagerDao;
import com.assignment.model.Manager;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements IManagerService {

	Logger log = LoggerFactory.getLogger(ManagerServiceImpl.class);

	private @Autowired IManagerDao managerDao;

	@Override
	public Boolean managerLoginVerification(String email, String password) {
		log.info("@managerLoginVerification in service invoked with email: {} and password: {}", email, password);
		Manager managerByEmail = managerDao.getManagerByEmail(email);
		Boolean exist = false;
		if (managerByEmail != null) {
			if (managerByEmail.getEmail().equals(email) && managerByEmail.getPassword().equals(password)) {
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
