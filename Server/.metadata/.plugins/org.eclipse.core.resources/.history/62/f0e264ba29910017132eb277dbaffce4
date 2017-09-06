package com.spring.advertisement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.advertisement.dao.UserDAO;
import com.spring.advertisement.entity.Advertise;
import com.spring.advertisement.entity.User;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDao;
	
	public User createUser(User user) {
		return userDao.createUser(user);
	}
	
	public String login(String userName, String password){
		return userDao.login(userName, password);
	}
	
	public String getCategories() throws JsonProcessingException{
		String str= userDao.getCategories();
		return str;
	}

	public String getActions() throws JsonProcessingException {
		return userDao.getActions();
	}

	public String logout(String auth_token) throws JsonProcessingException {
		return userDao.logout(auth_token);
	}

	public String postAd(Advertise ad, String auth_token) {
		return userDao.postAd(ad, auth_token);
	}

}