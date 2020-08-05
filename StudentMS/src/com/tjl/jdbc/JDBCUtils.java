package com.tjl.jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
	// 静态语句
	static {
		InputStream iS = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");

		Properties p = new Properties();
		try {
			p.load(iS);
			String driver = p.getProperty("driver");
			p.getProperty("url");
			p.getProperty("username");
			p.getProperty("password");
			Class.forName(driver);
			System.out.println("驱动加载成功");
		} catch (IOException | ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1?serverTimezone=UTC&useSSL=true", "root", "mysql");

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return null;
	}

	public static void close(Connection conn, PreparedStatement preparestatement, ResultSet result) {
		try {
			if (result != null) {
				((InputStream) result).close();
				result = null;
			}
			if (preparestatement != null) {
				((Closeable) preparestatement).close();
				preparestatement = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
