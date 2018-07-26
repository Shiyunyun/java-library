package com.neuedu.entity;

public class Teacher {
	private Integer id;//主键
	private String no;//工号
	private String password;//密码
	private String name;//姓名
	private String gender;//性别
	private String mobile;//电话
	private String qq;//qq号
	private String email;//邮箱
	private String job;//工作岗位
	
	public Teacher() {
		super();
	}
	
	public Teacher(String no, String password) {
		super();
		this.no = no;
		this.password = password;
	}

	public Teacher(Integer id, String no, String password, String name, String gender, String mobile, String qq,
			String email, String job) {
		super();
		this.id = id;
		this.no = no;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.qq = qq;
		this.email = email;
		this.job = job;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", no=" + no + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", mobile=" + mobile + ", qq=" + qq + ", email=" + email + ", job=" + job + "]";
	}
	
	public String[] toArray(){
		String[] arrstr=new String[8];
		arrstr[0]=this.id+"";
		arrstr[1]=this.no;
		arrstr[2]=this.name;
		arrstr[3]=this.gender;
		arrstr[4]=this.mobile;
		arrstr[5]=this.email;
		arrstr[6]=this.qq;
		arrstr[7]=this.job;
		return arrstr;
	}
}
