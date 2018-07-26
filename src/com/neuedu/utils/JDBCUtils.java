package com.neuedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.neuedu.entity.rowmapper.RowMapper;


public class JDBCUtils {
/*	public static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static String user = "scott";
	public static String password = "123456";*/
	
	public static String url="";
	public static String user="";
	public static String password="";
	
	static {
		
		//读取配置文件信息，加载到对应的变量
		Properties properties=new Properties();
		//获取输入流
		InputStream input=JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			
		try {
			properties.load(input);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		 String drivername=properties.getProperty("drivername");
		 url=properties.getProperty("url");
		 user=properties.getProperty("user");
		 password=properties.getProperty("password");
		
		//1.加载驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		
		//2.获得链接
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 使用Statement进行查询
	 * @return
	 */
	public static List executeQueryStm(String sql,RowMapper rowMapper){
		List list = null;
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			conn = JDBCUtils.getConnection();
			
			//3.获得Statement语句执行对象
			stm = conn.createStatement();
			
			//5.执行sql语句，获得结果集
			rs = stm.executeQuery(sql);
			
			list = new ArrayList<>();
			//6.处理结果集
			while(rs.next()) {
				
				list.add(rowMapper.getEntity(rs));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, stm, rs);
		}
		
		return list;
	}
	
	/**
	 * 使用Statement进行更新
	 * @return
	 */
	public static int executeUpdateStm(String sql){
		Connection conn = null;
		Statement stm = null;
		try {
			
			conn = JDBCUtils.getConnection();
			
			//3.获得Statement语句执行对象
			stm = conn.createStatement();
			
			//5.执行sql语句，获得结果集
			return stm.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, stm, null);
		}
		
		return 0;
	}
	
	/**
	 * 使用PreparedStatement进行查询
	 * @return
	 */
	public static List executeQueryPstm(String sql,RowMapper rowMapper,Object[] params){
		List list = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			conn = JDBCUtils.getConnection();
			
			//3.获得Statement语句执行对象
			pstm = conn.prepareStatement(sql);
			
			if(null!=params) {
				for(int i=0;i<params.length;i++) {
					pstm.setObject(i+1, params[i]);
				}
			}
			
			//5.执行sql语句，获得结果集
			rs = pstm.executeQuery();
			
			list = new ArrayList<>();
			//6.处理结果集
			while(rs.next()) {
				
				list.add(rowMapper.getEntity(rs));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, pstm, rs);
		}
		
		return list;
	}
	
	/**
	 * 使用PreparedStatement进行查询，得到一个结果
	 * @return
	 */
	public static Object executeQueryPstmOne(String sql,Object[] params){
		List list = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			conn = JDBCUtils.getConnection();
			
			//3.获得Statement语句执行对象
			pstm = conn.prepareStatement(sql);
			
			if(null!=params) {
				for(int i=0;i<params.length;i++) {
					pstm.setObject(i+1, params[i]);
				}
			}
			
			//5.执行sql语句，获得结果集
			rs = pstm.executeQuery();
			
			list = new ArrayList<>();
			//6.处理结果集
			while(rs.next()) {
				
				return rs.getObject(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, pstm, rs);
		}
		
		return null;
	}
	
	/**
	 * 使用PreparedStatement进行更新
	 * @return
	 */
	public static int executeUpdatePstm(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			conn = JDBCUtils.getConnection();
			
			//3.获得Statement语句执行对象
			pstm = conn.prepareStatement(sql);
			
			if(null!=params) {
				for(int i=0;i<params.length;i++) {
					pstm.setObject(i+1, params[i]);
				}
			}
			
			//5.执行sql语句，获得结果集
			return pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(conn, pstm, null);
		}
		return 0;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public static void close(Connection conn,Statement stm,ResultSet rs) {
		close(rs);
		close(stm);
		close(conn);
	}
	/**
	 * 关闭资源
	 * @param conn
	 */
	public static void close(Connection conn) {
		if(null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭资源
	 * @param stm
	 */
	public static void close(Statement stm) {
		
		if(null != stm) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 关闭资源
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if(null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
