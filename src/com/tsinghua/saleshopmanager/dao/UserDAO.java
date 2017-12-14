package com.tsinghua.saleshopmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.tsinghua.saleshopmanager.vo.SuperMarketUser;

public class UserDAO {

	private BaseDAO baseDAO = null;

	private ResultSet rs = null;

	private String sql = "";

	private SuperMarketUser user = null;

	/**
	 * 创建数据库操作对象
	 */
	public UserDAO() {
		if (baseDAO == null) {
			baseDAO = new BaseDAO();
		}
	}

	/**
	 * 查询单一用户信息
	 * 
	 * @param uName
	 *            用户名
	 * @param uPassword
	 *            密码
	 * @return 用户对象
	 */
	public SuperMarketUser checkUser(String uid, String uPassword) {

		sql = "select * from SuperMarketUser where UId='" + uid + "' and UPassword='" + uPassword + "'";
		System.out.println(sql);
		rs = baseDAO.executeQuery(sql);
		try {
			if (rs != null && rs.next()) {
				user = new SuperMarketUser();
				user.setUId(rs.getString("UId"));
				user.setUName(rs.getString("UName"));
				user.setUPassword(rs.getString("UPassword"));
				user.setURole(rs.getString("URole"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("用户数据查询失败");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询所有系统用户信息
	 * 
	 * @return 用户对象集合
	 */
	public Vector<Vector<String>> getUsers() {
		Vector<Vector<String>> vector = new Vector<Vector<String>>();
		sql = "select * from SuperMarketUser";
		rs = baseDAO.executeQuery(sql);
		try {
			while (rs != null && rs.next()) {
				Vector<String> v = new Vector<String>();
				v.addElement(rs.getString("UName"));
				v.addElement(rs.getString("UId"));
				v.addElement(rs.getString("UPassword"));
				v.addElement(rs.getString("URole"));

				vector.addElement(v);

			}
			return vector;
		} catch (SQLException e) {
			System.out.println("用户数据查询失败");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除用户信息
	 * 
	 * @param user的主键ID
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean delUser(SuperMarketUser user) {
		sql = "delete from SuperMarketUser where UId='" + user.getUId() + "'";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 *            修改的对象
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean updateUser(SuperMarketUser user) {
		if (user != null) {
			sql = "update SuperMarketUser set UName='" + user.getUName() + "' ,UPassword='" + user.getUPassword()
					+ "',URole='" + user.getURole() + "' where UId='" + user.getUId() + "'";
			if (baseDAO.executeUpdate(sql)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            新用户信息
	 * @return 操作状态（true：成功 false:失败）
	 */
	public boolean saveUser(SuperMarketUser user) {
		try {
			if (user != null) {
				// 验证账号不允许重复
				sql = "select * from SuperMarketUser where uid='" + user.getUId() + "'";
				System.out.println(sql);
				rs = baseDAO.executeQuery(sql);

				if (rs != null && rs.next()) {// 说明该数据库中已经存在该账号，不能添加
					System.out.println("+++++++++++++++++");
					return false;
				}
				sql = "insert into SuperMarketUser values('" + user.getUId() + "','" + user.getUName() + "','"
						+ user.getUPassword() + "','" + user.getURole() + "')";
				System.out.println(sql);

				if (baseDAO.executeUpdate(sql)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("数据插入失败！");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改密码
	 * 
	 * @param uid
	 *            账号
	 * @param upassword
	 *            新密码
	 * @return 操作状态
	 */
	public boolean updatePass(String uid, String upassword) {
		if (upassword == null || upassword.equals("")) {
			return false;
		}
		sql = "update SuperMarketUser set upassword='" + upassword + "' where uid='" + uid + "'";
		if (baseDAO.executeUpdate(sql)) {
			return true;
		}
		return false;

	}

	// 填充用户table的标题
	public Vector<String> getColoumn() {
		Vector<String> vector = new Vector<String>();
		vector.add("真实姓名");
		vector.add("账号");
		vector.add("密码");
		vector.add("角色");
		return vector;
	}

}
