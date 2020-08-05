package com.tjl.test;

import java.sql.Connection;
import java.sql.ResultSet;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;
import com.tjl.operate.Useroperate_imp;

public class JDBCUtilsTest {
	/**
	 * @throws Exception
	 */
	public void jdbcconnectiontest() throws Exception{
		Connection conn = JDBCUtils.getConnection();
		java.sql.Statement statement = conn.createStatement();
		ResultSet result =  statement.executeQuery("select * from user");
		while (result.next()) {
			System.out.println(result.getString("uname"));
			
		}
	}
	
	
	
	public void insertTest() throws Exception{
		Useroperate_imp useroperate_imp = new Useroperate_imp();
		boolean a= useroperate_imp.insert(new User("赵","haifen"));
		System.out.println(a);
	}
	
	public void delateTest() throws Exception{
		Useroperate_imp useroperate_imp = new Useroperate_imp();
		boolean a= useroperate_imp.delete("沈");
		System.out.println(a);
	}
	public void updateTest() throws Exception{
		Useroperate_imp useroperate_imp = new Useroperate_imp();
		boolean a= useroperate_imp.update(new User("赵","081838"));
		System.out.println(a);
	}
	public static void main(String[] args) {
		JDBCUtilsTest aJdbcUtilsTest= new JDBCUtilsTest();
		try {
			aJdbcUtilsTest.updateTest();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
