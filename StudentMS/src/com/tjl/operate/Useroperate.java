package com.tjl.operate;

import com.tjl.bean.User;

public interface Useroperate {

	/**
	 * 验证登陆的身份
	 * 
	 * @param user要登陆的用户, uname账户,upass密码
	 * @return int -1为登陆失败,1为管理员账户,2为学生账户
	 */
	int login(User user);

	/**
	 * 添加学生信息
	 * 
	 * @param user要添加的对象, 账户与密码
	 * @return 正常添加返回true,反之为false
	 */
	boolean insert(User user);

	/**
	 * 删除学生信息
	 * 
	 * @param user要删除的对象,uname
	 * @return 正常删除返回true,反之为false
	 */
	boolean delete(String uname);

	/**
	 * 修改学生信息
	 * 
	 * @param user要修改的对象
	 * @return 正常修改返回true,反之为false
	 */
	boolean update(User user);

}
