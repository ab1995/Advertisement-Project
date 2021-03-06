package com.project.advertisement.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.advertisement.dao.AdDAO;
import com.project.advertisement.dao.UserDAO;
import com.project.advertisement.entity.Advertise;
import com.project.advertisement.entity.DummyAdvertise;
import com.project.advertisement.entity.DummyMessage;
import com.project.advertisement.entity.Message;

public class AdServiceImpl implements AdService {

	@Autowired
	AdDAO adDao;
	
	public String getCategories() throws JsonProcessingException{
		String str= adDao.getCategories();
		return str;
	}

	public String getActions() throws JsonProcessingException {
		return adDao.getActions();
	}

	public String postAd(DummyAdvertise ad, String auth_token) {
		return adDao.postAd(ad, auth_token);
	}

	public String updateAd(Advertise ad, String auth_token) {
		return adDao.updateAd(ad, auth_token);
	}

	public String getUserAds(String authToken) {
		return adDao.getUserAds(authToken);
	}

	public String getUserAd(String authToken, int postId) {
		return adDao.getUserAd(authToken, postId);
	}

	public String deleteUserAd(String authToken, int postId) {
		return adDao.deleteUserAd(authToken, postId);
	}

	public String getAdDetail(String authToken, int postId) {
		return adDao.getAdDetail(authToken, postId);
	}

	public String searchByText(String authToken, String searchText) {
		return adDao.searchByText(authToken, searchText);
	}

	public String search(String authToken, String searchText, String category) {
		return adDao.search(authToken, searchText, category);
	}

	public String sendMessage(DummyMessage message, String auth_token) {
		return adDao.sendMessage(message, auth_token);
	}

	public String getDateConditions() throws JsonProcessingException {
		return adDao.getDateConditions();
	}

	public String getReceivedMessages(String authToken) {
		return adDao.getReceivedMessages(authToken);
	}
	
}
