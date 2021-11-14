package com.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Manager;

@Repository("IManagerDao")
public interface IManagerDao extends JpaRepository<Manager, Integer> {

	Manager getManagerByEmail(String email);

}
