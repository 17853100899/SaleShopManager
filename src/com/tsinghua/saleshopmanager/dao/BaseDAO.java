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
 * ��ɾ�Ĳ���
 * @param sql
 * @return ����ɾ�Ĳ�����״̬
 */
	public boolean executeUpdate(String sql) {
		conn = DBHelper.getConn();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Statement����ʧ��");
			e.printStackTrace();
		} 
		return false;
	}
/**
 * ��ѯ
 * @param sql
 * @return �����
 */
	public ResultSet executeQuery(String sql) {
		conn=DBHelper.getConn();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("���ݲ�ѯʧ��");
			e.printStackTrace();			
		}
	
		return null;
		
		
	}

}