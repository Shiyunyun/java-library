package com.neuedu.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.entity.Classes;

public class ClassesRowMapper implements RowMapper{

	@Override
	public Object getEntity(ResultSet rs) throws SQLException {
		Classes c=new Classes();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setStart_date(rs.getDate("start_date"));
		c.setEnd_date(rs.getDate("end_date"));
		c.setClassroom(rs.getString("classroom"));
		c.setStudy_direction(rs.getString("study_direction"));
		c.setCount(rs.getInt("count"));
		return c;
	}

}
