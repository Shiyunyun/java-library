package com.text.entity;

/**
 * @author hp
 *
 */
public class CertType {

	private Integer id;
	private String Content;
	public Integer getid() {
		return id;
	}
	public void setid(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}
	@Override
	public String toString() {
		return "CertType [id=" + id + ", Content=" + Content + "]";
	}
	
	
}
