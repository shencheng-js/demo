package com.tjl.operate;

import com.tjl.bean.Student;
import com.tjl.bean.User;

public interface Studentoperate {
	/**
	 * 添加学生信息
	 * 
	 * @param user要添加的对象, 账户与密码
	 * @return 正常添加返回true,反之为false
	 */
	boolean insert(Student student);

	/**
	 * 删除学生信息
	 * 
	 * @param user要删除的对象,uname
	 * @return 正常删除返回true,反之为false
	 */
	boolean delete(int sno);

	/**
	 * 修改学生信息   学号不变,其他需要内容包含在类内部
	 * 
	 * @param user要修改的对象
	 * @return 正常修改返回true,反之为false
	 */
	boolean update(Student student);

	/**
	 * 查询学生信息
	 * 
	 * @param user要查询的对象,uname
	 * @return 正常修改返回true,反之为false
	 */
	Student select(int sno);
	/*
	 * 查寻gpa更高的人数,即排名
	 */
	int Ranking(int sno);
	
	
	
	
}
