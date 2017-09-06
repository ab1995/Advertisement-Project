package com.project.advertisement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_MESSAGE")
public class Message {

	@GeneratedValue
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "MESSAGE")
	private String message;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="POST_ID")
	private Advertise adPost;
	
	
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="MESSAGE_SENDER")
	private User postedBy;
	
	@Column(name = "MESSAGE_RECIPENT")
	private String postedTo;
	
	
	public Message(){}


	public Message(String message, Advertise adPost, String postedTo, User postedBy) {
		super();
		this.message = message;
		this.adPost = adPost;
		this.postedTo = postedTo;
		this.postedBy = postedBy;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Advertise getAdPost() {
		return adPost;
	}


	public void setAdPost(Advertise adPost) {
		this.adPost = adPost;
	}


	public String getPostedTo() {
		return postedTo;
	}


	public void setPostedTo(String postedTo) {
		this.postedTo = postedTo;
	}


	public User getPostedBy() {
		return postedBy;
	}


	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}


	/*@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", adPost=" + adPost + ", postedTo=" + postedTo
				+ ", postedBy=" + postedBy + "]";
	}*/	
	
}
