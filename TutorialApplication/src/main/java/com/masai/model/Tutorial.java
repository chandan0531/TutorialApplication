package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tId;
	private String title;
	private String description;
	private String publishedStatus;
	
	
	public Tutorial(Integer tId, String title, String description, String publishedStatus) {
		super();
		this.tId = tId;
		this.title = title;
		this.description = description;
		this.publishedStatus = publishedStatus;
	}


	public Tutorial() {
	
	}


	public Integer gettId() {
		return tId;
	}


	public void settId(Integer tId) {
		this.tId = tId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPublishedStatus() {
		return publishedStatus;
	}


	public void setPublishedStatus(String publishedStatus) {
		this.publishedStatus = publishedStatus;
	}


	@Override
	public String toString() {
		return "Tutorial [tId=" + tId + ", title=" + title + ", description=" + description + ", publishedStatus="
				+ publishedStatus + "]";
	}
	
	
	
	
}
