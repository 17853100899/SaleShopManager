package com.tsinghua.saleshopmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static Connection conn = null;

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static String username = "sa";

	private static String password = "suger007..";
	// ���ݿ��ַ�����ݿ�����
	private static String url = "jdbc:sqlserver://120.79.43.219:1433;DatabaseName=saleshop;";

	static {
		try {
			Class.forName(driver);
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return ���ݿ����Ӷ���
	 */
	public static Connection getConn() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("���ӳɹ���");
			} catch (SQLException e) {
				System.out.println("����ʧ�ܣ�");
				e.printStackTrace();
			}
		}
		return conn;
	}

	/**
	 * �������ݿ������Ƿ�ɹ�
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DBHelper db = new DBHelper();
		db.getConn();
	}
}
