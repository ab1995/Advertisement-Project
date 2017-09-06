package com.spring.advertisement.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.advertisement.entity.Advertise;
import com.spring.advertisement.entity.User;

public interface UserDAO {
	public User createUser(User user);
	public String login(String userName, String password);
	public String getCategories() throws JsonProcessingException;
	public String getActions() throws JsonProcessingException;
	public String logout(String auth_token) throws JsonProcessingException;
	public String postAd(Advertise ad, String auth_token);
}
