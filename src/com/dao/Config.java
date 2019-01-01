package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * * <b>Description:数据库配置类</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 * 		<b>PackageName:</b> com.dao <br>
 * 		<b>ClassName:</b> Config <br>
 * 		<b>Date:</b> 2018年12月3日 下午8:38:26
 */

public class Config {
	/** 数据库连接地址 */
	private static String URL;

	/** 数据库用户名 */
	private static String USERNAME;

	/** 数据库密码 */
	private static String USERPASSWORD;

	/** mysql 驱动 */
	private static String DRIVER;

	/** 数据库配置信息 */
	private static ResourceBundle rb = ResourceBundle.getBundle("com.dao.db");

	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		USERPASSWORD = rb.getString("jdbc.userpassword");
		DRIVER = rb.getString("jdbc.driver");

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver error");
			System.out.println("数据库访问失败");
			e.printStackTrace();
		}
	}

	/**
	 * <b>Description:</b>获取与数据库的连接<br>
	 * 
	 * @return
	 * @Note <b>Author:</b> 李帆 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:39:12 <br>
	 * 		<b>Version:</b> 1.0
	 */

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, USERPASSWORD);
		} catch (SQLException e) {
			System.out.println("Get Connection error");
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * <b>Description:</b>关闭与数据库的连接<br>
	 * 
	 * @param rs
	 *            结果集（可空）
	 * @param ps
	 *            执行集（可空）
	 * @param conn
	 *            连接（可空）
	 * @Note <b>Author:</b> 李帆 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:39:38 <br>
	 * 		<b>Version:</b> 1.0
	 */

	public static void closeConnection(ResultSet rs, Statement ps, Connection conn) {
		try {
			if (null != rs)
				rs.close();
			if (null != ps)
				ps.close();
			if (null != conn)
				conn.close();
		} catch (SQLException e) {
			System.out.println("Close Connection error");
			System.out.println("数据库链接关闭失败");
			e.printStackTrace();
		}
	}
}
