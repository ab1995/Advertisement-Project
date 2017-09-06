package com.project.advertisement.entity;

public class DummyMessage {

	private int postId;
	private String message;
	
	public DummyMessage(){}

	public DummyMessage(int postId, String message) {
		super();
		this.postId = postId;
		this.message = message;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DummyMessage [postId=" + postId + ", message=" + message + "]";
	}
	
	
}
