package com.project.advertisement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SESSION")
public class UserSession {
	
	@Id
	@Column(name = "AUTH_TOKEN")
	private String authToken;
	
	@Column(name = "USER_NAME")
	private String userName;

	public UserSession(){}
	
	public UserSession(String authToken, String userName) {
		super();
		this.authToken = authToken;
		this.userName = userName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserSession [authToken=" + authToken + ", userName=" + userName + "]";
	}	
	
}
