package com.neuedu.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.entity.Teacher;
/**
 * 准备Teacher类的映射关系
 * @author hp
 *
 */
public class TeacherRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Teacher teacher=new Teacher();
		teacher.setId(rs.getInt("id"));
		teacher.setNo(rs.getString("no"));
//		teacher.setPassword(rs.getString("password"));
		teacher.setName(rs.getString("name"));
		teacher.setGender(rs.getString("gender"));
		teacher.setMobile(rs.getString("mobile"));
		teacher.setQq(rs.getString("qq"));
		teacher.setEmail(rs.getString("email"));
		teacher.setJob(rs.getString("job"));
		return teacher;
	}

}
