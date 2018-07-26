package com.text.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.text.entity.CertType;
import com.text.entity.City;
import com.text.entity.Province;
import com.text.entity.User;
import com.text.entity.UserType;

public class JDBCUtil {
	
	
	/*static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static Connection getConnection() throws NamingException, SQLException {
		//1、获取上下文
		Context context=new InitialContext();
		
		//2、获取数据源对象DataSource，参数格式：java:comp/env/ +在context.xml中配置的name属性值
		DataSource ds=(DataSource) context.lookup("java:comp/env/jdbc/oracle");
		
		//3、获取与数据库连接
		return ds.getConnection();
	}
	
	
	public static List executeQuery(String sql,Object[] params,Connection conn){
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		List list=null;
	
		try {
			
			pstm=conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			
			rs=pstm.executeQuery();
			
			list=new ArrayList<>();
			
			while(rs.next()){
				
				User user=new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setBirthday(rs.getDate("birthday"));
				
				City city=new City();
				city.setCity(rs.getString("city"));
				user.setCity(city);
				
				Province province=new Province();
				province.setProvince(rs.getString("province"));
				user.setProvince(province);
				
				user.setCert(rs.getString("cert"));
				
				CertType certType=new CertType();
				certType.setContent(rs.getString("contents"));
				user.setCertType(certType);
				
				user.setCert_type(rs.getInt("cert_type"));
				user.setRealName(rs.getString("realname"));
				user.setUser_type(rs.getInt("user_type"));
				
				UserType userType=new UserType();
				userType.setContent(rs.getString("ucontent"));
				user.setUserType(userType);
				
				user.setRule(rs.getString("rule"));
				user.setContent(rs.getString("content"));
				user.setImage_path(rs.getString("image_path"));
				list.add(user);
				
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs);
			JDBCUtil.close(pstm);
			
		}
		return null;
		
	}
	
	public static List executeQueryCity(String sql,Object[] params){
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=null;
		List list=null;
	
		try {
			conn=getConnection();
			pstm=conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			
			rs=pstm.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				
				City city=new City();
				city.setId(rs.getInt("id"));
				city.setCity(rs.getString("city"));
				city.setCityId(rs.getString("cityId"));
				city.setFather(rs.getString("father"));
				
				Province province=new Province();
				province.setPid(rs.getInt("id"));
				province.setProvince(rs.getString("province"));
				province.setProvinceId(rs.getString("provinceid"));
				
				city.setProvince(province);
				
				list.add(city);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs);
			JDBCUtil.close(pstm);
			JDBCUtil.close(conn);
		}
		return null;
		
	}
	
	public static List executeQueryProvince(String sql,Object[] params){
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Connection conn=null;
		List list=null;
	
		try {
			conn=getConnection();
			pstm=conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			}
			
			rs=pstm.executeQuery();
			list=new ArrayList<>();
			while(rs.next()){
				
				Province province=new Province();
				province.setPid(rs.getInt("id"));
				province.setProvince(rs.getString("province"));
				province.setProvinceId(rs.getString("provinceid"));
				
				list.add(province);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs);
			JDBCUtil.close(pstm);
			JDBCUtil.close(conn);
		}
		return null;
		
	}
	
	public static int executeUpdate(String sql,Object[] params,Connection conn){
		
		PreparedStatement pstm=null;
		try {
			
			
			 pstm=conn.prepareStatement(sql);
			 
			 if(params!=null){
				for(int i=0;i<params.length;i++){
					pstm.setObject(i+1, params[i]);
				}
			 }
			 
			 return pstm.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(null,pstm,null);
		}
		return 0;
		
	}
	
	public static void close(ResultSet rs,Statement stm,Connection conn){
		
		close(rs);
		close(stm);
		close(conn);
		
	}
	
	
	
	public static void close(ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stm){
		try {
			if(stm!=null){
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 开启事务
	 * @param conn
	 */
	public static void beginTransation(Connection conn){
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 * @param conn
	 */
	public static void commitTransation(Connection conn){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollBackTransation(Connection conn){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
