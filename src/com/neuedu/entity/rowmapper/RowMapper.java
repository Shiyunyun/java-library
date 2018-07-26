package com.neuedu.entity.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 约定实体类的封装映射关系
 * @author Administrator
 *
 */
public interface RowMapper {
	public Object getEntity(ResultSet rs) throws SQLException;
}
