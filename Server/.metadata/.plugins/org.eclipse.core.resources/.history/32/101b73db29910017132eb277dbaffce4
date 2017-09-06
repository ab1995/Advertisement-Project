package com.spring.advertisement.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.advertisement.collections.Actions;
import com.spring.advertisement.collections.Category;
import com.spring.advertisement.collections.UserAds;
import com.spring.advertisement.collections.UserCollection;
import com.spring.advertisement.collections.UserSession;
import com.spring.advertisement.entity.Advertise;
import com.spring.advertisement.entity.User;
import com.spring.advertisement.repository.ActionRepository;
import com.spring.advertisement.repository.CategoryRepository;
import com.spring.advertisement.repository.SessionRepository;
import com.spring.advertisement.repository.UserAdsRepository;
import com.spring.advertisement.repository.UserRepository;

public class UserMongoDAOImpl implements UserDAO{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ActionRepository actionRepository;
	
	@Autowired
	UserAdsRepository userAdsRepository;
	
	
	
	public User createUser(User user) {
		UserCollection userCollection=new UserCollection();
		userCollection.setFirstName(user.getFirstName());
		userCollection.setLastName(user.getLastName());
		userCollection.setUsername(user.getUserName());
		userCollection.setPassword(user.getPassword());
		userCollection.setEmail(user.getEmail());
		userCollection.setPhone(user.getPhone());
		userRepository.save(userCollection);
		return user;
	}
	
	public String login(String userName, String password){
		
		List<UserSession> tempSessionObj=sessionRepository.getLoginUserByUserName(userName);
		if(tempSessionObj.size()==0){
			List<UserCollection> user=userRepository.getAuthorisedUser(userName, password);
			UserSession userSession=new UserSession();
			userSession.setUserName(userName);
			UserSession tempSession= sessionRepository.save(userSession);

			if(tempSession==null)
				return "login Failed";
			else
			{	
				return tempSession.getId();
			}
		}
		else
		{	
			return ""+tempSessionObj.get(0).getId();
		}
		
		
		
	}
	
	public String getCategories() throws JsonProcessingException{
		List<Category> categories=categoryRepository.getCategories();
		
		String str="";
		ObjectMapper mapper=new ObjectMapper();
		str=mapper.writeValueAsString(categories);
		return str;
	}

	public String getActions() throws JsonProcessingException {
		List<Actions> actions=actionRepository.getActions();
		
		String str="";
		ObjectMapper mapper=new ObjectMapper();
		str=mapper.writeValueAsString(actions);
				
		return str;
	}

	public String logout(String auth_token) throws JsonProcessingException {
		List<UserSession> tempSessionObj=sessionRepository.getLoginUser(auth_token);
		String str="";
		ObjectMapper mapper=new ObjectMapper();
		if(tempSessionObj.size()==0)
			return mapper.writeValueAsString("Invalid auth-token");
		else
		{	
			sessionRepository.deleteSession(auth_token);	
			return mapper.writeValueAsString("Logout Successful!");
		}
	}

	public String postAd(Advertise ad, String auth_token) {
		List<UserSession> tempSessionObj=sessionRepository.getLoginUser(auth_token);
		if(tempSessionObj.size()==0)
			return "Invalid auth-token";
		else
		{	
			UserAds userAd=new UserAds();
			userAd.setTitle(ad.getTitle());
			userAd.setCategory(ad.getCategory());
			userAd.setDescription(ad.getDescription());
			userAd.setName(ad.getName());
			userAdsRepository.save(userAd);
			return "Ad Posted!";
		}
			
	}
}
