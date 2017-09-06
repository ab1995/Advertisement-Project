package com.project.advertisement.dao;


import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.advertisement.entity.User;
import com.project.advertisement.entity.UserSession;

public class UserDAOImpl extends HibernateDaoSupport  implements UserDAO {

	@Transactional
	public String createUser(User user) {
		List<User> checkIfUsernameExist=(List<User>)getHibernateTemplate().find("FROM User where USERNAME=?", user.getUserName());
		if(checkIfUsernameExist.size()>0){
			return "Username In Use";
		}
		else{
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
			getHibernateTemplate().save(user);
			return "Registration successful";
		}
	}

	@Transactional
	public String login(String userName, String password) {
		List<UserSession> prevUserSession=(List<UserSession>)getHibernateTemplate().find("FROM UserSession WHERE userName=?", userName);
		
		if(!prevUserSession.isEmpty()){
			return prevUserSession.get(0).getAuthToken();
		}
		else{
			List<User> checkIfUsernameExist=(List<User>)getHibernateTemplate().find("FROM User where USERNAME=?", userName);
			if(checkIfUsernameExist.size()==0){
				return "Invalid Credential";
			}
			else{
				boolean password_verified = BCrypt.checkpw(password, checkIfUsernameExist.get(0).getPassword());
				if(password_verified)
				{
					String authToken=UUID.randomUUID().toString();
					UserSession userSession=new UserSession(authToken,userName);
					getHibernateTemplate().save(userSession);
					return authToken;
				}
				else{
					return "Invalid Credential";
				}
			}
		}
		
	}

	@Transactional
	public String logout(String auth_token) throws JsonProcessingException {
		List<UserSession> prevUserSession=(List<UserSession>)getHibernateTemplate().find("FROM UserSession WHERE authToken=?", auth_token);

		if(!prevUserSession.isEmpty()){
			getHibernateTemplate().delete(prevUserSession.get(0));
			return "Logout Successful";
		}
		else{
			return "Invalid Operation";
		}
	}

	public String getUserDetails(String authToken) {
		List<UserSession> userSession=(List<UserSession>)getHibernateTemplate().find("FROM UserSession WHERE authToken=?", authToken);
		String str="Invalid auth-token";
		JSONObject json = new JSONObject();
		if(!userSession.isEmpty()){
			List<User> checkIfUsernameExist=(List<User>)getHibernateTemplate().find("FROM User where userName=?", userSession.get(0).getUserName());
			User requiredUser=checkIfUsernameExist.get(0);

			
		    json.put("firstName",requiredUser.getFirstName());
		    json.put("lastName",requiredUser.getLastName());
		    json.put("userName",requiredUser.getUserName());
		    json.put("email",requiredUser.getEmail());
		    json.put("phone",requiredUser.getPhone());
		    return json.toString();
		}
		json.put("Status", "Invalid auth-token");
		return json.toString();
	}
	


}
