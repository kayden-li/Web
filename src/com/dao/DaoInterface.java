package com.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * * <b>Description:</b>数据库方法接口<br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.dao <br>
 * 		<b>ClassName:</b> DaoInterface <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:41:48
 */

public interface DaoInterface {
	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>插入对象信息</dd>
	 * </dl>
	 * 
	 * @param obj
	 *            要插入的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int regiest(Object obj);

	public int insert_Food(Object obj);

	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>删除对象信息.</dd>
	 * </dl>
	 * 
	 * @param obj
	 *            要删除的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int delete_Food(Object obj);

	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>更新对象信息。</dd>
	 * </dl>
	 * 
	 * @param obj
	 *            要更新的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int update_User(Object obj);

	public int update_Food(Object obj);

	/**
	 * 通过对象ID查找对象信息.
	 * 
	 * @param cls
	 *            对象所属的类
	 * @param objId
	 *            对象ID
	 * 
	 * @return the student
	 */

	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>通过ID查找对象。</dd>
	 * </dl>
	 * 
	 * @param objId
	 *            对象ID
	 * @return 查到的对象。若找不到则返回null。
	 */
	public Object find(int objId);

	public Object find(String area);

	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>查找所有对象。</dd>
	 * </dl>
	 * 
	 * @return 对象列表
	 */
	public List<? extends Object> findAllUser();

	public List<? extends Object> findAllFood();

	/**
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>将结果集转换为对象列表</dd>
	 * </dl>
	 * 
	 * @param rs
	 *            要转换的结果集
	 * @return 转换得到的对象列表
	 */
	public List<? extends Object> UtoModel(ResultSet rs);

	public List<? extends Object> FtoModel(ResultSet rs);

	/**
	 * 
	 * 
	 * <dl>
	 * <dt>作用：</dt>
	 * <dd>登陆验证</dd>
	 * </dl>
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Object login(String username, String password);
}
