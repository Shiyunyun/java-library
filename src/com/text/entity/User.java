package com.text.entity;

import java.util.Date;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String realName;
	private String sex;
	private int cert_type;
	private int user_type;
	private String cert;
	private Date birthday;
	private String content;
	private String status;
	private String rule;
	private String login_ip;
	private String image_path;
	private City city;
	private Province province;
	private CertType certType;
	private UserType userType;
	public User() {
	}
	
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getCert() {
		return cert;
	}


	public void setCert(String cert) {
		this.cert = cert;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRule() {
		return rule;
	}


	public void setRule(String rule) {
		this.rule = rule;
	}


	public String getLogin_ip() {
		return login_ip;
	}


	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}


	public String getImage_path() {
		return image_path;
	}


	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public Province getProvince() {
		return province;
	}


	public void setProvince(Province province) {
		this.province = province;
	}


	public CertType getCertType() {
		return certType;
	}


	public void setCertType(CertType certType) {
		this.certType = certType;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	

	public int getCert_type() {
		return cert_type;
	}


	public void setCert_type(int cert_type) {
		this.cert_type = cert_type;
	}


	public int getUser_type() {
		return user_type;
	}


	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", realName=" + realName
				+ ", sex=" + sex + ", cert=" + cert + ", birthday=" + birthday + ", content=" + content + ", status="
				+ status + ", rule=" + rule + ", login_ip=" + login_ip + ", image_path=" + image_path + ", city=" + city
				+ ", province=" + province + ", certType=" + certType + ", userType=" + userType + "]";
	}

	
	

	

}
