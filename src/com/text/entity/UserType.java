package com.text.entity;

public class UserType {

	private Integer utId;
	private String Content;
	
	public Integer getUtId() {
		return utId;
	}
	public void setUtId(Integer utId) {
		this.utId = utId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}
	@Override
	public String toString() {
		return "UserType [utId=" + utId + ", Content=" + Content + "]";
	}
	
	
}
