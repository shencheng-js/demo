package com.tjl.test;

import com.tjl.bean.Student;
import com.tjl.bean.User;
import com.tjl.operate.Studentoperate_imp;
import com.tjl.operate.Useroperate_imp;

public class useroperateTest {

	
	
	public static void main(String[] args) {
		Studentoperate_imp aImp= new Studentoperate_imp();
		Student a = new Student(2018213261,"沈", 4051800,0,21,3.2);
		
		int i = aImp.Ranking(201821);
		System.out.println(i);
	}
}
