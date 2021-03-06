package com.project.advertisement.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USER_ADS")
public class Advertise {
	
	@GeneratedValue
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "POST_TIME")
	private Date postTime;	
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="CATEGORY")
	private Category category;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinColumn(name="AD_USER")
	private User adUser;
	
	
	
	@JsonIgnore
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy = "adPost")
	private Set<Message> messages;
	
	
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	public Advertise(){
	}

	public Advertise(String title, String name, Category category, String description) {
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public Advertise(int id, String title, String name, Category category, String description) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public User getAdUser() {
		return adUser;
	}

	public void setAdUser(User adUser) {
		this.adUser = adUser;
	}

	@Override
	public String toString() {
		return "Advertise [id=" + id + ", title=" + title + ", name=" + name + ", postTime=" + postTime + ", category="
				+ category.getCategoryName() + ", adUser=" + adUser.getUserName() + ", description=" + description + "]";
	}



}
