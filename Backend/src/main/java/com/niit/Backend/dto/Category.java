package com.niit.Backend.dto;

public class Category {
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURl() {
		return imageURl;
	}
	public void setImageURl(String imageURl) {
		this.imageURl = imageURl;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/* Private Fields */
	
	private int id;
	private String name;
	private String description;
	private String imageURl;
	private boolean active = true;
	
	

}
