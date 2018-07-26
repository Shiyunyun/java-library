package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Teacher;
/**
 * 基础Dao
 * @author hp
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 统计总记录数
	 * @return
	 */
	public int count(T t);
	/**
	 * 查询多行记录
	 * @param t
	 * @return
	 */
	public PageModel<T> select(PageModel<T> pageModel);
	/**
	 * 查询一行记录
	 * @param t
	 * @return
	 */
	public T selectOne(T t);
	/**
	 * 根据id查询一行记录
	 * @param id
	 * @return
	 */
	public T selectById(Integer id);
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public int add(T t);
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public int delete(T t);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(Integer id);
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	public int update(T t);

}
