package com.project.advertisement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATE_CONDITIONS")
public class DateConditions {

	@Id
	@Column(name = "CONDITION")
	private String condition;
	
	public DateConditions(){}

	public DateConditions(String condition) {
		super();
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "DateConditions [condition=" + condition + "]";
	}
	
	
}
