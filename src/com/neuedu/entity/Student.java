package com.neuedu.entity;

import java.sql.Date;

public class Student {
	private Integer id;//序号
	private String no;//学号
	private String name;//姓名
	private String gender;//性别
	private Integer class_id;//教室
	private String school;//学校
	private String profession;//专业
	private Date graduation_date;//毕业日期
	private String mobile;//电话
	private String email;//邮箱
	private String contact_relation;//联系人的关系
	private String contact_name;//联系人
	private String contact_phone;//联系人电话
	
	private static int i=1;//序号
	
	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		Student.i = i;
	}

	public Student() {
	}
	
	public Student(String no, String name) {
		this.no = no;
		this.name = name;
	}

	public Student(Integer id, String no, String name, String gender, int class_id, String school, String profession,
			Date graduation_date, String mobile, String email,  String contact_name,String contact_relation,
			String contact_phone) {
		super();
		this.id = id;
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.class_id = class_id;
		this.school = school;
		this.profession = profession;
		this.graduation_date = graduation_date;
		this.mobile = mobile;
		this.email = email;
		this.contact_relation = contact_relation;
		this.contact_name = contact_name;
		this.contact_phone = contact_phone;
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

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getGraduation_date() {
		return graduation_date;
	}

	public void setGraduation_date(Date graduation_date) {
		this.graduation_date = graduation_date;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_relation() {
		return contact_relation;
	}

	public void setContact_relation(String contact_relation) {
		this.contact_relation = contact_relation;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", no=" + no + ", name=" + name + ", gender=" + gender + ", class_id=" + class_id
				+ ", school=" + school + ", profession=" + profession + ", graduation_date=" + graduation_date
				+ ", mobile=" + mobile + ", email=" + email + ", contact_relation=" + contact_relation
				+ ", contact_name=" + contact_name + ", contact_phone=" + contact_phone + ", getId()=" + getId()
				+ ", getNo()=" + getNo() + ", getName()=" + getName() + ", getGender()=" + getGender()
				+ ", getClass_id()=" + getClass_id() + ", getSchool()=" + getSchool() + ", getProfession()="
				+ getProfession() + ", getGraduation_date()=" + getGraduation_date() + ", getMobile()=" + getMobile()
				+ ", getEmail()=" + getEmail() + ", getContact_relation()=" + getContact_relation()
				+ ", getContact_name()=" + getContact_name() + ", getContact_phone()=" + getContact_phone()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	public String[] toArray(){
		String[] stustr=new String[9];
		stustr[0]=(i++)+"";
		stustr[1]=this.no;
		stustr[2]=this.name;
		stustr[3]=this.gender;
		stustr[4]=this.school;
		stustr[5]=this.profession;
		stustr[6]=this.graduation_date==null?"":graduation_date.toString();
		stustr[7]=this.mobile;
		stustr[8]=this.email;
		return stustr;
	}
}
