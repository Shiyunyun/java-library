package com.neuedu.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.entity.Student;



public class StudentRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Student student=new Student();
		student.setId(rs.getInt("id"));
		student.setNo(rs.getString("no"));
		student.setName(rs.getString("name"));
		student.setGender(rs.getString("gender"));
		student.setClass_id(rs.getInt("class_id"));
		student.setSchool(rs.getString("school"));
		student.setProfession(rs.getString("profession"));
		student.setGraduation_date(rs.getDate("graduation_date"));
		student.setMobile(rs.getString("mobile"));
		student.setEmail(rs.getString("email"));
		student.setContact_relation(rs.getString("contact_relation"));
		student.setContact_name(rs.getString("contact_name"));
		student.setContact_phone(rs.getString("contact_phone"));
		return student;
	}
	
	
}
