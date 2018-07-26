package com.text.dao;

import java.util.List;

import com.text.entity.User;

public interface UserDao {
	//添加用户
	public boolean addUser(User user);
	//查询一个用户
	public User selectOne(User user);
	//更新用户
	public boolean updateUser(User user);
	//查询所有用户
	public List<User> selectAll(User user);
	//删除用户
	public boolean deleteUser(User user);
	//分页查询
	public List<User> selectAllByPage(User user,int pageNum,int pageSize);
}
