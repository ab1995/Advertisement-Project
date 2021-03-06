package com.project.advertisement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CATEGORY")
public class Category {
	
	@Id
	@Column(name = "NAME")
	private String categoryName;
	
	@JsonIgnore
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER, mappedBy = "category")
	private Set<Advertise> advertisements;

	public Category(){}
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Advertise> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertise> advertisements) {
		this.advertisements = advertisements;
	}

	@Override
	public String toString() {
		return categoryName ;
	}	
}
