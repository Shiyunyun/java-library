package com.text.entity;

/**
 * @author Administrator
 *
 */
public class Province {

	private Integer pid;
	private String provinceId;
	private String province;
	
	
	public Province() {
	}
	public Province(Integer pid, String provinceId, String province) {
		super();
		this.pid = pid;
		this.provinceId = provinceId;
		this.province = province;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", provinceId=" + provinceId + ", province=" + province + "]";
	}
	
	
	
}
