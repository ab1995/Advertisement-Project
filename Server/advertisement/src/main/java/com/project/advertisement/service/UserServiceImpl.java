package com.project.advertisement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.advertisement.dao.UserDAO;
import com.project.advertisement.entity.Advertise;
import com.project.advertisement.entity.User;


public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	public String createUser(User user) {
		return userDao.createUser(user);
	}
	
	public String login(String userName, String password){
		return userDao.login(userName, password);
	}
	
	public String logout(String auth_token) throws JsonProcessingException {
		return userDao.logout(auth_token);
	}

	public String getUserDetails(String authToken) {
		return userDao.getUserDetails(authToken);
	}

}