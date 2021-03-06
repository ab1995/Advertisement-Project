package com.project.advertisement.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.advertisement.entity.Advertise;
import com.project.advertisement.entity.User;


public interface UserDAO {
	public String createUser(User user);
	public String login(String userName, String password);
	public String logout(String auth_token) throws JsonProcessingException;
	public String getUserDetails(String authToken);
}
