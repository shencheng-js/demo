package com.tjl.operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class Useroperate_imp implements Useroperate {
	private static final String SQL_USER_LOGIN = "select type from user where uname=? and upass=?";
	private static final String SQL_USER_INSERT = "INSERT INTO USER VALUES(?,?,?)";
	private static final String SQL_USER_DELETE = "DELETE FROM USER WHERE uname=?";
	private static final String SQL_USER_UPDATE = "UPDATE USER SET UPASS=? where uname=?";

	@Override
	public int login(User user) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		ResultSet result = null;
		try {
			preparestatement = conn.prepareStatement(SQL_USER_LOGIN);
			preparestatement.setString(1, user.getUname());
			preparestatement.setString(2, user.getUpass());

			result = preparestatement.executeQuery();
			while (result.next()) {
				int type = result.getInt("type");
				return type;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, result);
		}

		return -1;
	}

	@Override
	public boolean insert(User user) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = conn.prepareStatement(SQL_USER_INSERT);
			preparestatement.setString(1, user.getUname());
			preparestatement.setString(2, user.getUpass());
			preparestatement.setString(3, String.valueOf(user.getType()));
			int updateline = preparestatement.executeUpdate();

			if (updateline > 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, null);
		}

		return false;
	}

	@Override
	public boolean delete(String uname) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = conn.prepareStatement(SQL_USER_DELETE);
			preparestatement.setString(1, uname);
		
			int updateline = preparestatement.executeUpdate();

			if (updateline > 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, null);
		}

		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = conn.prepareStatement(SQL_USER_UPDATE);
			preparestatement.setString(1, user.getUpass());
			preparestatement.setString(2, user.getUname());
			int updateline = preparestatement.executeUpdate();

			if (updateline > 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, null);
		}
		return false;
	}


}
