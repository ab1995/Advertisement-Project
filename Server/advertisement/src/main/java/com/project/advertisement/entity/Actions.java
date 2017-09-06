package com.project.advertisement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIONS")
public class Actions {
	
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String actionName;

	public Actions(){}
	
	public Actions(Long id, String actionName) {
		super();
		this.id = id;
		this.actionName = actionName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	@Override
	public String toString() {
		return "Actions [id=" + id + ", actionName=" + actionName + "]";
	}
	
	
}
