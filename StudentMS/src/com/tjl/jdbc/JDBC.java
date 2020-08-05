package com.tjl.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class JDBC {
	public static void main(String[] args) {
		
		try {
			
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("驱动加载成功");
			//连接数据库
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1?serverTimezone=UTC&useSSL=true", "root", "mysql");
			System.out.println("连接成功");
			//创建执行环境
			java.sql.Statement statement = conn.createStatement();
			ResultSet result =  statement.executeQuery("select * from user");
			while (result.next()) {
				System.out.println(result.getString("uname"));
				
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("驱动加载失败");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("连接失败");
		}
		
	}
}
