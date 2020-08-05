package com.tjl.operate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tjl.bean.Student;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

public class Studentoperate_imp implements Studentoperate {
	private static final String SQL_STUDENT_select = "select * from STUDENT where Sno=?";
	private static final String SQL_STUDENT_INSERT = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
	private static final String SQL_STUDENT_DELETE = "DELETE FROM STUDENT where Sno=?";
	private static final String SQL_STUDENT_UPDATE = "UPDATE STUDENT SET Sname=?,class=?,Sex=?,Age=?,GPA=? where Sno=?";
	private static final String SQL_STUDENT_Ranking = "SELECT COUNT(*) FROM STUDENT WHERE GPA>(SELECT GPA FROM STUDENT WHERE Sno=?)";

	@Override
	public boolean insert(Student student) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {

			preparestatement = conn.prepareStatement(SQL_STUDENT_INSERT);
			preparestatement.setInt(1, student.getSno());
			preparestatement.setString(2, student.getSname());
			preparestatement.setInt(3, student.getSclass());
			preparestatement.setInt(4, student.getSex());
			preparestatement.setInt(5, student.getAge());
			preparestatement.setDouble(6, student.getGpa());

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
	public boolean delete(int sno) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = conn.prepareStatement(SQL_STUDENT_DELETE);
			preparestatement.setInt(1, sno);

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
	public boolean update(Student student) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		try {
			preparestatement = conn.prepareStatement(SQL_STUDENT_UPDATE);
			preparestatement.setInt(6, student.getSno());
			preparestatement.setString(1, student.getSname());
			preparestatement.setInt(2, student.getSclass());
			preparestatement.setInt(3, student.getSex());
			preparestatement.setInt(4, student.getAge());
			preparestatement.setDouble(5, student.getGpa());
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
	public Student select(int sno) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		ResultSet rs = null;
		int sno1 = 0;
		String sname = null;
		int Sclass = 0;
		int sex = 0;
		int age = 0;
		double gpa = 0;
		try {
			preparestatement = conn.prepareStatement(SQL_STUDENT_select);
			preparestatement.setInt(1, sno);

			rs = preparestatement.executeQuery();
			while (rs.next()) {
				sno1 = rs.getInt("Sno");
				sname = rs.getString("Sname");
				Sclass = rs.getInt("class");
				sex = rs.getInt("Sex");
				age = rs.getInt("Age");
				gpa = rs.getDouble("GPA");
			}

			return new Student(sno1, sname, Sclass, sex, age, gpa);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, rs);
		}

		return null;
	}

	@Override
	public int Ranking(int sno) {
		// TODO 自动生成的方法存根
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement preparestatement = null;
		ResultSet rs = null;
		int sno1 = 0;
		try {
			preparestatement = conn.prepareStatement(SQL_STUDENT_Ranking);
			preparestatement.setInt(1, sno);
			rs = preparestatement.executeQuery();
			int testage = select(sno).getAge();
			if (testage == 0) {
				return 0;
			}
			while (rs.next()) {
				sno1 = rs.getInt("COUNT(*)");
			}
			return sno1 + 1;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.close(conn, preparestatement, rs);
		}

		return 0;
	}

}
