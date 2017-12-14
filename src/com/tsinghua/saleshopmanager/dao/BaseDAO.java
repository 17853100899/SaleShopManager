package com.tsinghua.saleshopmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tsinghua.saleshopmanager.util.DBHelper;

public class BaseDAO {
	private Connection conn = null;

	private ResultSet rs = null;

	private Statement stmt = null;
/**
 * 增删改操作
 * @param sql
 * @return （增删改操作）状态
 */
	public boolean executeUpdate(String sql) {
		conn = DBHelper.getConn();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Statement建立失败");
			e.printStackTrace();
		} 
		return false;
	}
/**
 * 查询
 * @param sql
 * @return 结果集
 */
	public ResultSet executeQuery(String sql) {
		conn=DBHelper.getConn();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("数据查询失败");
			e.printStackTrace();			
		}
	
		return null;
		
		
	}

}
