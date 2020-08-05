package com.tjl.bean;

public class Student {
	private int sno;
	private String sname;
	private int Sclass;
	private int sex;
	private String sexString;
	private int age;
	private double gpa;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSclass() {
		return Sclass;
	}

	public void setSclass(int sclass) {
		Sclass = sclass;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String toString() {
		sexString = "女性";
		if (sex == 1) {
			sexString = "男性";
		}
		return "该同学学号为" + sno + ", 姓名为" + sname + ", 班级号为" + Sclass + ", 性别为" + sexString + "";
	}

	public Student(int sno, String sname, int sclass, int sex, int age, double gpa) {
		super();
		this.sno = sno;
		this.sname = sname;
		Sclass = sclass;
		this.sex = sex;

		this.age = age;
		this.gpa = gpa;
	}

	public Student() {
		// TODO 自动生成的构造函数存根
	}

}
