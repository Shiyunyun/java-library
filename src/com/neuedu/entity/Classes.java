package com.neuedu.entity;

import java.sql.Date;

public class Classes {
	
	private Integer id;//id
	private String name;//名称
	private	Date start_date;//开始日期
	private Date end_date;//结束日期
	private String study_direction;//学习方向
	private String classroom;//教室
	private int count;//人数
	
	
	public Classes() {
	}
	
	public Classes(Integer id, String name, Date start_date, Date end_date, String study_direction, String classroom,
			int count) {
		this.id = id;
		this.name = name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.study_direction = study_direction;
		this.classroom = classroom;
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStudy_direction() {
		return study_direction;
	}
	public void setStudy_direction(String study_direction) {
		this.study_direction = study_direction;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", study_direction=" + study_direction + ", classroom=" + classroom + ", count=" + count + "]";
	}
	
	
	public String[] toArray(){
		String[] clastr=new String[7];
		clastr[0]=id+"";
		clastr[1]=name;
		clastr[2]=classroom;
		clastr[3]=study_direction;
		clastr[4]=start_date==null?"":start_date.toString();
		clastr[5]=end_date==null?"":end_date.toString();
		clastr[6]=count+"";
		return clastr;
	}
	
}
