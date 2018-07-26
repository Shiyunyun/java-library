package com.text.entity;

public class City {
	
	private Integer id;
	private String cityId;
	private String city;
	private String father;
	private Province province;
	
	public City() {
	}

	public City(Integer id, String cityId, String city, String father, Province province) {
		this.id = id;
		this.cityId = cityId;
		this.city = city;
		this.father = father;
		this.province = province;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", cityId=" + cityId + ", city=" + city + ", father=" + father + ", province="
				+ province + "]";
	}

	
	

	
}
