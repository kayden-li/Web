package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Food;
import com.model.User;

/**
 * * <b>Description:</b><br>
 * 
 * @author 李帆
 * @version 1.0
 * @Note <b>ProjectName:</b> MyWeb <br>
 *       <b>PackageName:</b> com.dao <br>
 *       <b>ClassName:</b> Operation <br>
 *       <b>Date:</b> 2018年11月29日 上午10:33:41
 */
public class Operation implements DaoInterface {

	/**
	 * <b>Description:注册</b><br>
	 * 
	 * @param obj
	 *            需要注册的用户
	 * @return 成功返回1，失败为0
	 * @Note <b>Author:</b> 刘浩 <br>
	 * 		<b>Date:</b> 2018年12月3日 下午8:42:59 <br>
	 * 		<b>Version:</b> 1.0
	 */
	@Override
	public int regiest(Object obj) {
		int flag = 0;
		User user = (User) obj;

		String sql = " insert into user( " + "  name, area, sex, id, number, password" + " ) values (" + "  ?,?,?,?,?,?"
				+ " )";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getArea());
				pstmt.setBoolean(3, user.getSex());
				pstmt.setString(4, user.getId());
				pstmt.setString(5, user.getNumber());
				pstmt.setString(6, user.getPassword());

				pstmt.execute();
				flag = 1;
			} catch (SQLException e) {
				System.out.println("User: insert param error");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("User: create PrepareStatement error");
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return flag;
	}

	/**
	 * <b>Description:</b>添加菜谱<br>
	 * 
	 * @param obj
	 *            菜谱
	 * @return 成功返回1，失败为0
	 * @Note <b>Author:</b> 李帆 <br>
	 *       <b>Date:</b> 2018年12月3日 上午10:36:58 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public int insert_Food(Object obj) {
		int flag = 0;
		Food food = (Food) obj;

		String sql = " insert into food( " + "  name, area, intro, img, publisher" + " ) values (" + "  ?,?,?,?,?"
				+ " )";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, food.getName());
				pstmt.setString(2, food.getArea());
				pstmt.setString(3, food.getIntro());
				pstmt.setString(4, food.getImg());
				pstmt.setString(5, food.getPublisher());

				pstmt.execute();
				flag = 1;
			} catch (SQLException e) {
				System.out.println("Food: insert param error");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Food: create PrepareStatement error");
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return flag;
	}

	/**
	 * <b>Description:删除菜谱</b><br>
	 * 
	 * @param obj
	 *            菜谱
	 * @return 成功返回1，失败为0
	 * @Note <b>Author:</b> 李帆 <br>
	 *       <b>Date:</b> 2018年12月3日 上午10:37:27 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public int delete_Food(Object obj) {
		int f = 0;
		String std = (String) obj;
		String sql = "delete from food " + " where name = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, std);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt.execute();
			f = 1;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return f;
	}

	/**
	 * <b>Description:更新用户信息</b><br>
	 * 
	 * @param obj
	 *            用户
	 * @return 成功返回1，失败为0
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:37:44 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public int update_User(Object obj) {
		int f = 0;
		User user = (User) obj;

		String sql = "update user t " + " set t.name = ? " + " , t.area = ? " + " , t.sex = ? " + " , t.password = ? "
				+ " , t.number = ? " + " where id = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getArea());
				pstmt.setBoolean(3, user.getSex());
				pstmt.setString(4, user.getPassword());
				pstmt.setString(5, user.getNumber());
				pstmt.setString(6, user.getId());
			} catch (SQLException e) {
				System.out.println("User: update param error");
				e.printStackTrace();
			}
			pstmt.execute();
			f = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return f;
	}

	/**
	 * <b>Description:更新菜谱信息</b><br>
	 * 
	 * @param obj
	 *            食物
	 * @return 成功返回1，失败为0
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:38:00 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public int update_Food(Object obj) {
		int f = 0;
		Food food = (Food) obj;

		String sql = "update food " + " set area = ? " + " , intro = ? " + " , img = ? " + " , publisher = ? "
				+ " where name = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, food.getArea());
				pstmt.setString(2, food.getIntro());
				pstmt.setString(3, food.getImg());
				pstmt.setString(5, food.getName());
				pstmt.setString(4, food.getPublisher());
			} catch (SQLException e) {
				System.out.println("Food: update param error");
				e.printStackTrace();
			}
			pstmt.execute();
			f = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return f;
	}

	/**
	 * <b>Description:查找用户</b><br>
	 * 
	 * @param objId
	 *            用户id
	 * @return 用户或空
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:38:12 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public Object find(int objId) {
		String sql = "select * from  user  where id = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setInt(1, objId);
			} catch (SQLException e) {
				System.out.println("User: select param error");
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			List<Object> UsersList = this.UtoModel(rs);
			if (UsersList != null && UsersList.size() == 1) {
				return (User) UsersList.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 * <b>Description:按地区查找菜谱</b><br>
	 * 
	 * @param area
	 *            省份名
	 * @return 菜谱集合
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:38:32 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public List<Food> find(String area) {
		String sql = "select * from  food  where area = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, area);
			} catch (SQLException e) {
				System.out.println("Food: select param error");
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			List<Food> FoodsList = this.FtoModel(rs);
			if (FoodsList != null) {
				return FoodsList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 * <b>Description:查找所有用户</b><br>
	 * 
	 * @return 用户集合
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:38:50 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public List<Object> findAllUser() {
		String sql = "select * from  user  order by id ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			List<Object> usersList = this.UtoModel(rs);
			if (usersList != null) {
				return usersList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 * <b>Description:查找所有菜谱</b><br>
	 * 
	 * @return 菜谱集合
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:39:00 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public List<Food> findAllFood() {
		String sql = "select * from  food  order by area ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			List<Food> foodsList = this.FtoModel(rs);
			if (foodsList != null) {
				return foodsList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 * <b>Description:将ResultSet转换为user</b><br>
	 * 
	 * @param rs
	 *            结果集
	 * @return 用户集合
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:39:16 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public List<Object> UtoModel(ResultSet rs) {
		@SuppressWarnings("unchecked")
		List<Object> UsersList = new ArrayList();
		try {
			while (rs.next()) {
				User user = new User();

				user.setName(rs.getString("name"));
				user.setArea(rs.getString("area"));
				user.setSex(rs.getBoolean("sex"));
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setNumber(rs.getString("number"));

				UsersList.add(user);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return UsersList;
	}

	/**
	 * <b>Description:将ResultSet转换为food</b><br>
	 * 
	 * @param rs
	 *            结果集
	 * @return 菜谱集合
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:40:02 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public List<Food> FtoModel(ResultSet rs) {
		@SuppressWarnings("unchecked")
		List<Food> FoodsList = new ArrayList();
		try {
			while (rs.next()) {
				Food food = new Food();

				food.setName(rs.getString("name"));
				food.setArea(rs.getString("area"));
				food.setIntro(rs.getString("intro"));
				food.setImg(rs.getString("img"));
				food.setPublisher(rs.getString("publisher"));

				FoodsList.add(food);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return FoodsList;
	}

	/**
	 * <b>Description:获取菜谱总数</b><br>
	 * 
	 * @return 已发布的菜谱总数
	 * @Note <b>Author:</b> 李帆 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:40:35 <br>
	 *       <b>Version:</b> 1.0
	 */

	public int getCount() {
		String sql = "select count(*) cnt from food ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return 0;
	}

	/**
	 * <b>Description:登陆验证</b><br>
	 * 
	 * @param username
	 *            用户id
	 * @param password
	 *            密码
	 * @return 登录成功的用户信息或空
	 * @Note <b>Author:</b> 刘浩 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:40:53 <br>
	 *       <b>Version:</b> 1.0
	 */
	@Override
	public Object login(String username, String password) {
		String sql = "select * from user where id = ? and password = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			try {
				pstmt.setString(1, username);
				pstmt.setString(2, password);
			} catch (SQLException e) {
				System.out.println("Login: select param error");
				e.printStackTrace();
			}
			ResultSet rs = pstmt.executeQuery();
			List<Object> user = this.UtoModel(rs);
			if (user.size() != 0) {
				return user.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

	/**
	 * <b>Description:检测用户id是否可用</b><br>
	 * 
	 * @param id
	 *            待检测id
	 * @return bool
	 * @Note <b>Author:</b> 李帆 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:41:02 <br>
	 *       <b>Version:</b> 1.0
	 */

	public boolean check(String id) {
		String sql = "select count(*) cnt from user where id=?";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			try {
				pstmt.setString(1, id);
			} catch (SQLException e) {
				System.out.println("Login: select param error");
				e.printStackTrace();
			}

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("cnt") != 0)
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return true;
	}

	/**
	 * <b>Description:查找我发布的菜谱</b><br>
	 * 
	 * @param publisher
	 *            发布者
	 * @return 我发布的菜谱集合
	 * @Note <b>Author:</b> 李帆 <br>
	 *       <b>Date:</b> 2018年11月29日 上午10:41:39 <br>
	 *       <b>Version:</b> 1.0
	 */

	public List<Food> findMyFood(String publisher) {
		String sql = "select * from  food  where publisher = ? ";
		Connection conn = Config.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publisher);

			ResultSet rs = pstmt.executeQuery();
			List<Food> foodsList = this.FtoModel(rs);
			if (foodsList != null) {
				return foodsList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Config.closeConnection(null, pstmt, conn);
		}
		return null;
	}

}
