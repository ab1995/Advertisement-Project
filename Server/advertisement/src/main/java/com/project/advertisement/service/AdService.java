package com.project.advertisement.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.advertisement.entity.Advertise;
import com.project.advertisement.entity.DummyAdvertise;
import com.project.advertisement.entity.DummyMessage;
import com.project.advertisement.entity.Message;

public interface AdService {
	public String getCategories() throws JsonProcessingException;
	public String getActions() throws JsonProcessingException;
	public String postAd(DummyAdvertise ad, String auth_token);
	public String updateAd(Advertise ad, String auth_token);
	public String getUserAds(String authToken);
	public String getUserAd(String authToken, int postId);
	public String deleteUserAd(String authToken, int postId);
	public String getAdDetail(String authToken, int postId);
	public String searchByText(String authToken, String searchText);
	public String search(String authToken, String searchText, String category);
	public String sendMessage(DummyMessage message, String auth_token);
	public String getDateConditions() throws JsonProcessingException;
	public String getReceivedMessages(String authToken);
}
